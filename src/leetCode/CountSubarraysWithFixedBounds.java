package leetCode;

public class CountSubarraysWithFixedBounds {
    // leetcode 2444
    // 大概逻辑就是，枚举所有可能的右边界，然后每次记录一下min和max，如果超过了给定范围就重新更新左边界
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int min = -1;
        int max = -1;
        int i0 = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == minK){
                min = i;
            }
            if(nums[i] == maxK){
                max = i;
            }
            if(nums[i] < minK || nums[i] > maxK){
                i0 = i;
            }
            result += Math.max(Math.min(min, max) - i0, 0);
        }
        return result;
    }
}
