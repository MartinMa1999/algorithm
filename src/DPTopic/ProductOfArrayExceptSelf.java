package DPTopic;

public class ProductOfArrayExceptSelf {
    // Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the
    // product of all the elements of nums except nums[i].
    //
    // Solve it without division and in O(n).
    // 和longest valid parentheses很像，就是每次只能处理好一边的数据，所以需要两次遍历

    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            tmp *= nums[i + 1];
            result[i] *= tmp;
        }
        return result;
    }
}
