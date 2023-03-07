package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraySumsDivisiblebyK {
    // Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
    //
    //A subarray is a contiguous part of an array.

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK subarraySumsDivisiblebyK = new SubarraySumsDivisiblebyK();
        subarraySumsDivisiblebyK.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5);
    }
    public int subarraysDivByK(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int result = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); //bug!如果不用map存，前面prefixSum存在相等的情况时候就会少结果。为了减少结果，应该在map里面存mode，而不是结果，否则遍历时间太久
        map.put(0, 1);
        for(int i : nums){
            prefixSum += i;
            int mode = (prefixSum % k + k) % k; // java负数的余数是个负数
            int num = map.getOrDefault(mode, 0);
            result += num;
            map.put(mode, num + 1);
        }

        return result;
    }
}
