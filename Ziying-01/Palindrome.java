import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s);
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    public static boolean isPalindrome(String s){
        if (s == ""){
            return true;
        }

        else{
            char[] stringArray = s.toCharArray();
            int left = 0;
            int right = stringArray.length-1;

            while (left <= right){
                while ((left <= stringArray.length-1) && (!Character.isLetterOrDigit(stringArray[left]))){
                    left++;
                }
                while ((right >= 0) && (!Character.isLetterOrDigit(stringArray[right]))){
                    right--;
                }
                if ((left <= stringArray.length-1) && (right >= 0) && (Character.toLowerCase(stringArray[left]) != Character.toLowerCase(stringArray[right]))){
                    return false;
                }
                else{
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
}
