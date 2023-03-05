package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoDifferenceInSortedArray {
    // Given a sorted array A, find a pair (i, j) such that A[j] - A[i] is identical to a target number(i != j).
    //
    //If there does not exist such pair, return a zero length array.

    public int[] twoDiff(int[] array, int target) { // TC = O(n ^ 2)
        if(array == null || array.length == 0){
            return array;
        }

        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(Math.abs(array[j] - array[i]) == Math.abs(target)){
                    if(array[j] - array[i] == target){
                        return new int[]{i, j};
                    }
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{};
    }


    public int[] betterWay(int[] array, int target) { // TC = O(n)
        if(array == null || array.length == 0){
            return array;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(! map.containsKey(array[i])){
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        int[] result = new int[2];
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i] - target)){
                for(int j : map.get(array[i] - target)){
                    if(j != i){
                        if(i > j){
                            return new int[]{j, i};
                        }
                        result[0] = j;
                        result[1] = i;
                    }
                }

            }
        }

        return result[0] == result[1] ? new int[]{} : result;
    }
}
