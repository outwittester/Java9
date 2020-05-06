public class StringEquals {
    public static void main(String[] args) {
        char[] v1 = {'a','b','c'};
        char[] v2 = {'a','b','c'};
        for (int i = 0; i <v1.length ; i++) {
            if (v1[i] == v2[i]){
                System.out.println("v1[" + i +"]=" + "v2[" +i + "]");
            }else {
                System.out.println("v1[" + i +"]!=" + "v2[" +i + "]");
            }

        }
        int n = v1.length;
        int i = 0;
        while (n-- != 0) {
            System.out.println(n);
            if (v1[i] != v2[i]) {
                System.out.println("not equal");
            } else {
                System.out.println("equal");
            }
            i++;
        }

    }

}
