class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = nums.length - 1; i >= 0; i--){
                map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                result[0] = i;
                result[1] = map.get(temp);
            }
        }
        
        return result;
    }
}
