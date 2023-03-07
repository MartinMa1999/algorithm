package leetCode;

import java.util.Arrays;

public class JumpGameII {
    // leetcode 45

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        jumpGameII.jump(new int[]{2,3,1,1,4});
    }

    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }

        int[] helper = new int[nums.length];
        Arrays.fill(helper, Integer.MAX_VALUE);
        helper[0] = 0;
        for(int i = 0; i < nums.length; i++){
            int tmp = nums[i];
            for(int j = 1; j < tmp && i + j < nums.length; j++){
                helper[i + j] = Math.min(helper[i + j], helper[i] + 1);

            }
        }

        return helper[helper.length - 1];
    }
}
