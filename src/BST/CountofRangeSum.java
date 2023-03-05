package BST;

import java.util.Arrays;

public class CountofRangeSum {
    // Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
    // Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

    //方法和get count array完全一样。通过得到的prefix sum之间做差来得到有多少段可以用的。使用mergesort对prefix sum进行排序，因为mergesort
    // 一定是先排左后排右，因此左边的对应的最后一个数在nums里面的index一定比右边小，因此直接算右边减左边符合要求的个数就可以了。
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] prefix = new int[nums.length + 1];
        int sum = 0;
        for(int i = 1; i < prefix.length; i++){
            sum += nums[i - 1];
            prefix[i] = sum;
        }
        int[] count = new int[1];

        mergeSort(prefix, lower, upper, count, 0, prefix.length - 1);
        return count[0];
    }
    private int[] mergeSort(int[] array, int lower, int upper, int[] count, int left, int right){
        if(left == right){
            return new int[]{array[left]};
        }

        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, lower, upper, count, left, mid);
        int[] rightResult = mergeSort(array, lower, upper, count, mid + 1, right);

        int i = 0;
        int fast = 0;
        int slow = 0;
        while(i < leftResult.length){
            while(slow < rightResult.length && rightResult[slow] - leftResult[i] < lower){
                slow++;
            }
            while(fast < rightResult.length && rightResult[fast] - leftResult[i] <= upper){
                fast++;
            }
            count[0] += fast - slow;
            i++;
        }

        return merge(leftResult, rightResult);
    }
    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }

        while(i < left.length){
            result[k++] = left[i++];
        }
        while(j < right.length){
            result[k++] = right[j++];
        }
        return result;
    }
}
