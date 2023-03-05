package crossTrainingDIY;

import java.util.Arrays;

public class TwoSumSmaller {
    // Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.
    // 如果有两个相同的数，就看做两个不同的数
    public int smallerPairs(int[] array, int target) {
        Arrays.sort(array);
        int result = 0;
        for(int j = array.length - 1; j > 0; j--){
            for(int i = j - 1; i >= 0; i--){
                if(array[i] + array[j] < target){
                    result += i + 1;
                    break;
                }
            }
        }
        return result;
    }
}
