import java.io.*;

public class getPath{
    public static void main(String args[]){
	String argsOne = args[0];
	String output = argsOne.substring(0, argsOne.lastIndexOf("/"));
	System.out.println(output);
    }

}
