package leetCode;

public class SearchInsertPosition {
    // leetcode 35
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 5);
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] == target){
                return mid;
            }
            else{
                right = mid;
            }
        }

        if (nums[left] >= target){
            return left;
        }

        if (nums[right] < target){
            return right + 1;
        }

        return right;
    }
}
