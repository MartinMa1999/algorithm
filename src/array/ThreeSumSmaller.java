package array;

import java.util.Arrays;

public class ThreeSumSmaller {
    // Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
    // that satisfy the condition nums[i] + nums[j] + nums[k] < target.

    public int threeSumSmaller(int[] num, int target) {
        if(num == null || num.length <= 2){
            return 0;
        }
        Arrays.sort(num);
        int sum = 0;
        for(int i = num.length - 1; i >= 2; i--){
            int tmp = findTwo(num, i - 1, target - num[i]);
            sum += tmp;
        }

        return sum;
    }
    private int findTwo(int[] array, int index, int target){
        int result = 0;
        for(int i = index; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if(array[j] + array[i] < target){
                    result += j + 1;
                    break;
                }
            }
        }
        return result;
    }
}
