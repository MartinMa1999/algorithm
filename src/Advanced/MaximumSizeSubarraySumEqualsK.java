package Advanced;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    // Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            if(! map.containsKey(prefix)){
                map.put(prefix, i);
            }

            if(map.containsKey(prefix - k)){
                result = Math.max(result, i - map.get(prefix - k));
            }
        }
        return result;
    }
}
