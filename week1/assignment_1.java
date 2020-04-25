// "static void main" must be defined in a public class.
import java.util.*;
public class assignment_1 {    
    //palindrome 
    private static boolean isPalindrome(String x){
            for(int i = 0, j = x.length() - 1; i < j; i++, j--){
                if(x.charAt(i) != x.charAt(j)){
                    return false;
                }
            }
        return true;
    }
    
    //up side down triangle 
    private static void triangle(){
        for(int i=5;i>0;i--){
            for(int j=0;j<5-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print(" *");
            }
        System.out.println();
        }
    }
    
    //divisor 
    private static void getDivisors(int input) {
        for(int i=1;i<=input;i++){
            if (input%i==0){
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "level";
        System.out.println(isPalindrome(str));
        triangle();
        getDivisors(68834021);
        
    }

}
