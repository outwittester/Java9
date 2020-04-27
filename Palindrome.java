import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))) {
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”
                return true;
            }

            while (end >= 0 && ! isvalid(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                front++;
                end--;
            }
        }

        return true;
    }

    private static boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}