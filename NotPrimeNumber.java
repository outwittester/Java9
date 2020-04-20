import java.util.*;

public class NotPrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean res = notPrimeNum(num);
        System.out.println(res);
        if (res == true) {
            System.out.println(num + " is composite number.");
        }
        else {
            System.out.println(num + " is not composite number.");
        }
    }

    public static boolean notPrimeNum(int num) {
        List<Integer> primeList = new ArrayList<Integer>();
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return false;
        }

        int prime = 2;
        while (prime * prime <= num) {
            while (num % prime == 0) {
                primeList.add(prime);
                num /= prime;
            }
            prime++;
        }
        if (num != 1) {
            primeList.add(num);
        }

        if (primeList.isEmpty()) {
            return true;
        }
        else {
            return false;
        }

    }
}
