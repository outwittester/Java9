import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

//http://tutorials.jenkov.com/java-json/jackson-jsonnode.htmls
//https://attacomsian.com/blog/jackson-json-node-tree-model
//https://www.jianshu.com/p/ac8d51a50aa7

public class IOStreamReadWriteJson {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Read file
        InputStream inputStream = new FileInputStream("data.json");
        byte[] buffer = new byte[200];
        StringBuilder sb = new StringBuilder();
        int length;
        while (-1 != (length = inputStream.read(buffer, 0, 200))) {
            String tmp = new String(buffer, 0, length);
            sb.append(tmp);
        }
        inputStream.close();

        String str = sb.toString();

        // Inspect head of file
        String[] tokens = str.split("\\n");
        for (int i = 0; i < 6; i++) System.out.println(tokens[i]);
        System.out.println("\n===============\n");


        // Convert to JsonNode and get the information
        JsonNode root = new ObjectMapper().readTree(str);
        String tmp3 = root.path("service").path("serviceHeader").path("clientId").asText();
        System.out.println(tmp3);
        String orderTypeVal = root.findValue("orderType").asText();
        System.out.println(orderTypeVal);
        String dueTodayVal = root.findValue("dueToday").asText();
        System.out.println(dueTodayVal);

        List<String> emailList = new ArrayList<>();
        emailList = root.findValuesAsText("email");
        Collections.sort(emailList);
        for (String each : emailList) System.out.println(each);

        JsonNode node = root.findValue("shippingAddress");
        Iterator<String> it = node.fieldNames();
        List<String> shippingAddressField = new ArrayList<>();
        while (it.hasNext()) {
            String field = it.next();
            String tmp = node.findValue(field).asText();
            shippingAddressField.add(tmp);
        }
        //StringBuilder sbShippingAddress = new StringBuilder();
        String shippingAddressVal = String.join(",", shippingAddressField);


        System.out.println("\n===============\n");


        // Create ObjectNode using the information
        ObjectNode jnode = new ObjectMapper().createObjectNode();
        jnode.put("orderType", orderTypeVal);
        jnode.put("dueToday", dueTodayVal);
        ArrayNode anode1 = jnode.putArray("email");
        for (String each : emailList) anode1.add(each);
        jnode.put("shippingAddress", shippingAddressVal);
        System.out.println(jnode);


        // Convert to String and output to text file
        String outputStr = jnode.toString();
        System.out.println(outputStr);

        OutputStream os = new FileOutputStream("output0.txt");
        byte[] bufferOut = outputStr.getBytes();
        os.write(bufferOut);
        os.close();


        // Output to specific format
        StringBuilder sbOut = new StringBuilder();
        sbOut.append("{");

        Iterator<String> itOut = jnode.fieldNames();
        while (itOut.hasNext()) {
            String field = itOut.next();
            sbOut.append("'" + field + "': {");
            JsonNode tmp = jnode.get(field);
            if (tmp.isArray()) {
                for (JsonNode each : tmp) sbOut.append("'" + each.asText() + "',");
                sbOut.deleteCharAt(sbOut.length() - 1);
            } else sbOut.append("'" + tmp.asText() + "'");
            sbOut.append("},");
        }
        sbOut.deleteCharAt(sbOut.length() - 1);
        sbOut.append("}");

        String sbOutStr = sbOut.toString();
        System.out.println(sbOutStr);

        OutputStream osFormat = new FileOutputStream("output.txt");
        BufferedOutputStream bos = new BufferedOutputStream(osFormat);
        byte[] bufferFormat = sbOutStr.getBytes();
        bos.write(bufferFormat);
        bos.close();
        osFormat.close();
        System.out.println("\n===============\n");


        // Read the output file
        InputStream is = new FileInputStream("output.txt");
        byte[] isBuffer = new byte[200];
        StringBuffer sbReadOutput = new StringBuffer();
        int outLength;
        while (-1 != (outLength = is.read(isBuffer, 0, 200))) {
            String tmp = new String(isBuffer, 0, outLength);
            sbReadOutput.append(tmp);
            System.out.println(sbReadOutput);
        }

        String sbReadOutputStr = new String(sbReadOutput);
        System.out.println("The read result:");
        System.out.println(sbReadOutputStr);

    }
}
