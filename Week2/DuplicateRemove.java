//Remove duplicates in array

import java.util.*;

public class DuplicateRemove {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 10, 11, 12, 12, 13, 14, 14, 14, 14, 14, 14, 14, 14};
        List<Integer> result = new ArrayList<Integer>();
        result = removeDuplicate(input);
        System.out.println(result);
        result = removeDuplicateHash(input);
        System.out.println(result);
        int[] res = removeDuplicateInPlace(input);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    public static int[] removeDuplicateInPlace(int[] input) {
        int i = 0;
        for (int j = 0; j < input.length; j++) {
            if (input[i] != input[j]) {
                i++;
                input[i] = input[j];
            }
        }
        return Arrays.copyOfRange(input, 0, i+1);
    }
    //双指针
    public static List<Integer> removeDuplicate(int[] input) {
        int i = 0;
        int j = 1;
        List<Integer> result = new ArrayList<Integer>();
        while (j < input.length) {
            if (input[i] != input[j]) {
                result.add(input[i]);
                i++;
                j++;
            }
            else {
                while ((j < input.length) && (input[i] == input[j])) {
                    j++;
                }
                if ((j < input.length) && (input[i] != input[j])){
                    result.add(input[i]);
                    i = j;
                    j++;
                }
                else {
                    result.add(input[i]);
                }
            }
        }
        return result;
    }

    // HashSet
    public static List<Integer> removeDuplicateHash(int[] input) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (!set.contains(input[i])) {
                set.add(input[i]);
                result.add(input[i]);
            }
        }
        return result;
    }
}
