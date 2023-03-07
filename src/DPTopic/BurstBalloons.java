package DPTopic;

public class BurstBalloons {
    // Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
    // You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
    // Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
    //
    //Find the maximum coins you can collect by bursting the balloons wisely.
    //
    //Note:
    //(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    //(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

    // 注意因为如果先选第一个burst的，就会导致后面的dp没办法做，所以每次都是得先选最后一个爆的，这样左右两边的值不会受到影响

    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] array = new int[nums.length + 2]; // 把边界值1放进去
        array[0] = 1;
        array[array.length - 1] = 1;
        for(int i = 0; i < nums.length; i++){
            array[i + 1] = nums[i];
        }
        int[][] helper = new int[array.length][array.length];

        for(int j = 2; j < array.length; j++){
            for(int i = j - 2; i >= 0; i--){// 因为ij是个开区间，所以区间长度为0的值一定是0
                for(int k = i + 1; k < j; k++){
                    int num = array[k] * array[i] * array[j];
                    num += helper[i][k] + helper[k][j];
                    helper[i][j] = Math.max(helper[i][j], num);
                }
            }
        }

        return helper[0][helper.length - 1];

    }
}
