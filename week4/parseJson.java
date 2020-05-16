import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.tools.javac.util.Convert;

public class parseJson {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InputStream inputStream = new FileInputStream("data.json");
        byte[] buffer = new byte[200]; //each time can only store 200 long
        int length = 0;
        //every time read from the source to buffer
        //each time put into buffer from 0 position to the length of 200
        //actual content is length
        //check if it returns -1 which means end of source

        String str = "";
        while (-1 != (length = inputStream.read(buffer, 0, 200))) {
//            String each = new String(buffer, 0, length);//now should know why need length variable
//            System.out.println(each);
            str+= new String(buffer, 0, length);

        }

        //remove all the white space
        //str = str.replaceAll("\\s+", "");
        //System.out.println(str);
        inputStream.close(); //all stream must close after using


        JsonNode node = new ObjectMapper().readTree(str);

//        String orderTypeVal = node.findValue("orderType").asText();
//        System.out.println(orderTypeVal);
//
//        String dueTodayVal = node.findValue("dueToday").asText();
//        System.out.println(dueTodayVal);

        List<String> orderTypeList = node.findValuesAsText("orderType");
        for (String each : orderTypeList) System.out.println(each);

        List<String> dueTodayList = node.findValuesAsText("dueToday");
        for (String each : dueTodayList) System.out.println(each);

        List<String> emailList = node.findValuesAsText("email");
        Collections.sort(emailList);
        for (String each : emailList) System.out.println(each);

        JsonNode shippingAddress = node.findValue("shippingAddress");
        Iterator<String> it = shippingAddress.fieldNames();
        List<String> shippingAddressList = new ArrayList();
        String temp = "";
        while (it.hasNext()) {
            String field = it.next();
            //shippingAddressList.add(shippingAddress.findValue(field).asText());
            temp += shippingAddress.findValue(field).asText();
            if(it.hasNext()){
                temp+= ",";
            }
        }
        shippingAddressList.add(temp);

        ObjectNode jsonObject = new ObjectMapper().createObjectNode();

        ArrayNode orderTypeNodes = jsonObject.putArray("orderType");
        for (String each : orderTypeList){
            orderTypeNodes.add(each);
        }

        ArrayNode dueTodayNodes = jsonObject.putArray("dueToday");
        for (String each : dueTodayList){
            dueTodayNodes.add(each);
        }

        ArrayNode emailNodes = jsonObject.putArray("email");
        for (String each : emailList){
            emailNodes.add(each);
        }

        ArrayNode shippingAddressNodes = jsonObject.putArray("shippingAddress");
        for (String each : shippingAddressList){
            shippingAddressNodes.add(each);
        }
        System.out.println(jsonObject);

//         Convert to String and output to text file
        String jsonString = jsonObject.toString().replaceAll("\\[", "\\{")
                                                 .replaceAll("\\]", "\\}")
                                                 .replaceAll("\"", "\'");
        System.out.println(jsonString);

        OutputStream os = new FileOutputStream("output.txt");
        byte[] bufferOut = jsonString.getBytes();
        os.write(bufferOut);
        os.close();

    }
}
