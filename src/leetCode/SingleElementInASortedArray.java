package leetCode;

public class SingleElementInASortedArray {
    // leetcode 540
    //You are given a sorted array consisting of only integers where every element appears exactly twice,
    // except for one element which appears exactly once.
    //
    //Return the single element that appears only once.

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid - 1]){
                if((mid - left + 1) % 2 == 0){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            else if(nums[mid] == nums[mid + 1]){
                if((right - mid + 1) % 2 == 0){
                    right = mid - 1;
                }
                else{
                    left = mid;
                }
            }
            else{
                return nums[mid];
            }
        }

        return nums[right];
    }
}
