import java.io.File;

public class FileDirectoryPrint {

    private static int tabNum = 0;

    public static void main(String[] args) {
        File file = new File("/Users/ziyingfeng/Downloads/Java9");
        System.out.println(file.isDirectory());
        String dir = "/Users/ziyingfeng/Downloads/Java9";
        printDir(dir);
    }

    public static void printDir(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                tabNum++;
                printDir(f.toString());
                tabNum--;
            }
            else {
                for (int i = 0; i < tabNum; i++) System.out.print("\t");
                System.out.println(f.toString());
            }
        }
    }
}
