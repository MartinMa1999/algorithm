package leetCode;

public class MaximumSumCircularSubarray {
    // Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
    //
    //A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
    //
    //A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

    public static void main(String[] args) {
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        maximumSumCircularSubarray.maxSubarraySumCircular(new int[]{-3,-2,-3});
    }
    public int maxSubarraySumCircular(int[] nums) {
        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        int max = nums[0];
        int sum = nums[0];
        int sumAll = nums[0];
        for(int i = 1; i < nums.length; i++){
            sumAll += nums[i];
            sum = sum < 0 ? nums[i] : sum + nums[i];
            max = Math.max(max, sum);
        }

        int min = 0; // bug! 因为范围从1开始，所以min不可能是0，而应该是第一个，所以min的初始值应该为0，因为有可能都是正数只会递增
        sum = nums[0];
        for(int i = 1; i < nums.length - 1; i++){ // bug !!如果是一个两端的东西，则第一个和最后一个必须包含在里面，所以范围是从 1 到 n-2
            sum = sum > 0 ? nums[i] : sum + nums[i];
            min = Math.min(sum, min);
        }


        return Math.max(max, sumAll - min);

    }

}
