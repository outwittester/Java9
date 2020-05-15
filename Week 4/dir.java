import java.io.*;

public class dir {
    public static void main(String[] args) throws IOException{
        String dir = "C:\\Users\\Leo\\Desktop\\targum";
        File f = new File(dir);
        if(f.isDirectory()){
            System.out.println("Directory: " + dir);
            String[] s = f.list();
            for(int i = 0; i < s.length; i++){
                File f2 = new File(dir + "\\" + s[i]);
                if(f2.isDirectory()){
                    System.out.println("Directory: "+s[i]);
                }
                else{
                    System.out.println("File: "+s[i]);
                }
            }
        }

    }
}
