package DPTopic;

public class HouseRobberII {
    // After robbing those houses on that street, the thief has found himself a new place for his thievery so that
    // he will not get too much attention. This time, all houses at this place are arranged in a circle.
    // That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses
    // remain the same as for those in the previous street.

    // 如果不好判断走到最后的时候是否rob了第一间，则直接考虑两种情况，一种是rob第一间，一种是不rob。
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int rob1 = nums[0] + rob(nums, 2, nums.length - 2);
        int rob2 = rob(nums, 1, nums.length - 1);

        return Math.max(rob1, rob2);
    }
    private int rob(int[] nums, int left, int right){
        if(left > right){ // bug!!如果超界则说明一个都不能抢
            return 0;
        }
        int rob = nums[left];
        int norob = 0;
        for(int i = left + 1; i <= right; i++){
            int rob1 = rob;
            int norob1 = norob;
            rob = norob1 + nums[i];
            norob = Math.max(rob1, norob1);
        }
        return Math.max(rob, norob);
    }
}
