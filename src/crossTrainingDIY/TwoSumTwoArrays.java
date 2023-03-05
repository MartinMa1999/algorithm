package crossTrainingDIY;

import java.util.HashSet;
import java.util.Set;

public class TwoSumTwoArrays {
    // Given two arrays A and B, determine whether there exists a pair of elements,
    // one drawn from each array, that sums to the given target number.
    public boolean existSum(int[] a, int[] b, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i : a){
            set.add(i);
        }
        for(int i : b){
            if(set.contains(target - i)){
                return true;
            }
        }
        return false;
    }
}
