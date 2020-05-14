public class Fibonacci {
    public static void main(String[] args) {
        int idx = 9;
        System.out.println(fib(idx));
        System.out.println(improveFib(idx));
    }

    public static int fib (int idx) {
        if (idx == 0) return 0;
        if (idx == 1) return 1;
        return fib(idx-1) + fib(idx-2);
    }

    public static int improveFib (int idx) {
        int f0 = 0;
        int f1 = 1;
        if (idx == 0) return f0;
        if (idx == 1) return f1;

        int f2 = f0 + f1;
        for (int i = 2; i <= idx; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
