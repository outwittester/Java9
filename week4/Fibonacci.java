public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println(improvedFib(8));
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
        long f2 = 1;

        if (index == 0) {
            return f0;
        }

        else if (index == 1) {
            return f1;
        }

        else if (index == 2) {
            return f2;
        }
        ;

        for (int i = 3; i <= index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }
}
