import java.util.HashMap;

public class Fibonacci {
    static long fib(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }
    }

    static long fibV2(long index) {
        HashMap<Long, Long> fibHash = new HashMap<Long, Long>();
         if(fibHash.containsKey(index)) {
             return fibHash.get(index);
         }
         if (index == 0) {
             return 0;
         }
         if (index == 1) {
             return 1;
         }
         Long value = fibV2(index - 1) + fibV2(index - 2);
         fibHash.put(index, value);
         return value;
    }
    public static void main(String[] args) {
        int idx = 20;
        System.out.println("For number 20, fibonacci is: " + fib(idx));
        System.out.println("For number 20, improved fibonacci is: " + fibV2(idx));
    }
}
