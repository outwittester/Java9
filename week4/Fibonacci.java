public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(improvedFib(10));
    }
    public static long fib(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }
    }

    public static long improvedFib(long index) {
        long f0 = 0;
        long f1 = 1;

        if (index == 0) {
            return 0;
        }
        else if (index == 1) {
            return 1;
        }

        for (int i = 2; i <= index; i++) {
            long temp = f0 + f1;
            f0 = f1;
            f1 = temp;
        }

        return f1;
    }
}