package crossTrainingII;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public boolean twoSum(int[] array, int target){
        //assume unsorted
        Set<Integer> set = new HashSet<>();
        for (int j : array) {
            if (!set.contains(target - j)) {
                set.add(j);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean methodTwo(int[] array, int target){
        //assume array is sorted in ascending order
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(array[i] + array[j] < target){
                i++;
            }
            else if(array[i] + array[j] == target){
                return true;
            }
            else{
                j--;
            }
        }
        return false;
    }
}
