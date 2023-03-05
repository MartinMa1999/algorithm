package array;

import java.util.Arrays;

public class ThreeSumClosest {
    // Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    // Return the difference between the sum of the three integers and the given number.
    // You may assume that each input would have exactly one solution.

    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3){
            return Integer.MAX_VALUE;
        }

        Arrays.sort(num);
        int result = Integer.MAX_VALUE;
        for(int i = num.length - 1; i >= 2; i--){
            int tmp = findTwo(num, i - 1, target - num[i]);
            result = Math.min(result, tmp);
        }
        return result;
    }
    private int findTwo(int[] array, int index, int target){
        int i = 0;
        int j = index;
        int result = Integer.MAX_VALUE;

        while(i < j){
            result = Math.min(result, Math.abs(target - array[i] - array[j]));
            if(array[i] + array[j] > target){
                j--;
            }
            else if(array[i] + array[j] == target){
                return 0;
            }
            else{
                i++;
            }
        }
        return result;

    }
}
