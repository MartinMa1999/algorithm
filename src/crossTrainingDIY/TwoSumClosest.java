package crossTrainingDIY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {
    // Find the pair of elements in a given array that sum to a value that is closest to the given target number.
    // Return the values of the two numbers.
    public List<Integer> closest(int[] array, int target) {
        // 如果用set，就需要把array traverse，并且每次都要和set里面的所有元素相加进行比较，TC = O(n^2)，如果排序就是logn
        if(array == null || array.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        int value = Math.abs(array[i] + array[j] - target);
        List<Integer> list = Arrays.asList(array[i], array[j]);
        while(i < j){
            if(Math.abs(array[i] + array[j] - target) < value){
                value = Math.abs(array[i] + array[j] - target);
                list = Arrays.asList(array[i], array[j]);
            }
            if(array[i] + array[j] < target){
                i++;
            }
            else if(array[i] + array[j] == target){
                break;
            }
            else{
                j--;
            }
        }
        return list;
    }
}
