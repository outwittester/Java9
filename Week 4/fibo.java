public class fibo {
    
    public static void main(String[] args) {
        int i = 10;
        System.out.println(fiboo(i));
    }

    public static int fiboo (int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;
        return fiboo(i - 1) + fiboo(i -2);
    }


}
