package leetCode;

import java.util.HashMap;

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(target - nums[i])){
                return new int[]{i, numMap.get(target - nums[i])};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }
}
