package crossTrainingII;

import java.util.Arrays;

public class FourSum {
    public boolean exist(int[] array, int target) {
        if(array == null || array.length < 4) {
            return false;
        }
        Arrays.sort(array);
        for(int i = 0; i < array.length - 3; i++) {
            if(getThree(array, i + 1, target - array[i])) {
                return true;
            }
        }
        return false;
    }
    private boolean getThree(int[] array, int index, int target) {
        for(int i = index; i < array.length - 2; i++) {
            if(getTwo(array, i + 1, target - array[i])) {
                return true;
            }
        }
        return false;
    }
    private boolean getTwo(int[] array, int index, int target) {
        int left = index;
        int right = array.length - 1;

        while(left < right) {
            int tmp = array[left] + array[right];
            if(tmp == target) {
                return true;
            }
            else if(tmp > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }
}
