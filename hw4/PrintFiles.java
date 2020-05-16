import java.io.File;

public class PrintFiles {
public static void main(String[]args){
        File path = new File("/Users/tianhangzhang/Documents");
        File[] fileList = path.listFiles();
        for (int i = 0; i < fileList.length; ++i) {
            if (fileList[i].isFile()) {
                System.out.println("File: " + fileList[i].getName());
            } else if (fileList[i].isDirectory()) {
                System.out.println("Directory: " + fileList[i].getName());
            }
        }

}



}
