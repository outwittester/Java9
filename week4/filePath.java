import java.io.*;


public class filePath{
    
    public static void main(String[] args) throws IOException{
	Scanner s =new Scanner(System.in);
	System.out.println("enter a path: ");
	
	String filePath = s.nextLine();
	
	while(!f.isDirectory()){
	    System.out.println("The path is not a directory!");
	    System.out.println("enter a path: ");
	    filePath = s.nextLine();
	}
	 File f = new File(filePath);
	 InputStream input = new FileinputStream();
    }
    
}
