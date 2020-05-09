import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; ++i) {
            if (map.containsKey(target - numbers[i])) {
                int[] res = {map.get(target - numbers[i]), i};
                return res;
            } else {
                map.put(numbers[i], i);
            }
        }
        System.out.println("Not applicable");
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 11, 21};
        for (int element : nums) {
            System.out.print(element + ",");
        }
        System.out.println();
        int[] result = twoSum(nums, 13);
        System.out.println("For target 13 the result is " + result[0] + ", " + result[1] );
        int[] result2 = twoSum(nums, 31);
    }
}
