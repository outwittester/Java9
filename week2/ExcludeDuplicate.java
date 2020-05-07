import java.util.Arrays;

public class ExcludeDuplicate {
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 11, 12, 12, 13, 14, 14, 14, 14, 14, 14, 14, 14};
        int[] res = test(input);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    private static int[] test(int[] input){
        int slow = 0;
        int fast = 0;
        while (fast<input.length){
            if (input[fast] !=input[slow]){
                input[++slow] = input[fast];
            }
            fast++;
        }

        return Arrays.copyOf(input,slow+1);


        }
}
