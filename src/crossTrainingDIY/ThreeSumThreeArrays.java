package crossTrainingDIY;

import java.util.HashSet;
import java.util.Set;

public class ThreeSumThreeArrays {
    public boolean exist(int[] a, int[] b, int[] c, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i : a){
            for(int j : b){
                set.add(i + j);
            }
        }
        for(int i : c){
            if(set.contains(target - i)){
                return true;
            }
        }
        return false;
    }
}
