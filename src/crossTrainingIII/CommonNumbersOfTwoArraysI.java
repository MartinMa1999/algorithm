package crossTrainingIII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonNumbersOfTwoArraysI {
    //no duplicate numbers
    public List<Integer> commonNumbers(int[] a, int[] b){
        //assume input array cannot be null and length > 0

        Set<Integer> set = new HashSet<>();
        for(int num : a){
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for(int element : b){
            if(set.contains(element)){
                result.add(element);
            }
        }

        return result;
    }
}
