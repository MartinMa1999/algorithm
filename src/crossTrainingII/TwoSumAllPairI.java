package crossTrainingII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairI {
    public List<List<Integer>> allResults(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(target - array[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                for(int index : map.get(target - array[i])){
                    list.add(index);
                    result.add(new ArrayList<>(list));
                    list.remove(1);
                }
            }

            if(! map.containsKey(array[i])){
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);

        }
        return result;
    }
}
