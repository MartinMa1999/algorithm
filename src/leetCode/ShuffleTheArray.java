package leetCode;

public class ShuffleTheArray {
    // leetcode 1470
    // Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    //
    //Return the array in the form [x1,y1,x2,y2,...,xn,yn].
    //

    public static void main(String[] args) {
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        shuffleTheArray.shuffle(new int[]{1,2,3,4,5,6}, 3);
    }
    public int[] shuffle(int[] nums, int n) {
        if(n <= 1){
            return nums;
        }
        recursion(nums, 0, nums.length - 1);
        return nums;
    }

    private void recursion(int[] nums, int left, int right){
        if(right - left < 2){
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftmid = left + size / 4;
        int rightmid = left + size * 3 / 4;

        reverse(nums, leftmid, mid - 1);
        reverse(nums, mid, rightmid - 1);
        reverse(nums, leftmid, rightmid - 1);


        recursion(nums, left, left + 2 * (leftmid - left) - 1);
        recursion(nums, left + 2 * (leftmid - left), right);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
