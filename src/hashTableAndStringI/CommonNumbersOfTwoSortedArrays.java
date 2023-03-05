package hashTableAndStringI;

import java.util.*;

public class CommonNumbersOfTwoSortedArrays {
    //assume there could be duplicate numbers
    public List<Integer> common(int[] array1, int[] array2){
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : array1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : array2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        return result;
    }
}
