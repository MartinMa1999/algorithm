package leetCode;

import java.util.Random;

public class SortAnArray {
    // leetcode 912

    public int[] sortArray(int[] nums) { // quicksort + rainbow sort
        if(nums == null || nums.length <= 1){
            return nums;
        }

        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, pivotIndex, right);
        int i = left;
        int j = left;
        int k = right - 1;
        while(j <= k){
            if(nums[j] < nums[right]){
                swap(nums, i, j);
                i++;
                j++;
            }
            else if(nums[j] == nums[right]){
                j++;
            }
            else{
                swap(nums, j, k);
                k--;
            }
        }

        swap(nums, right, i);
        quicksort(nums, left, i - 1);
        quicksort(nums, j, right);
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
