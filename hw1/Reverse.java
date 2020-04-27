import java.util.Scanner;
public class Reverse{
    public static void main(String[] args) {
        System.out.println("Input your number and press enter: ");

        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        System.out.println("Reverse number is: " + reverseInt(num));
    }

    private static int reverseInt(int x) {
        int currentDigit;
        long result = 0;
        while (x != 0) {
            currentDigit = x % 10;
            result = result * 10 + currentDigit;
            x /= 10;
        }
        if(result > 2147483647 || result < -2147483648){
            return 0;
        } else {
            return (int) result;
        }
    }
}