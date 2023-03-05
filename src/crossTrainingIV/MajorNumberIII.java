package crossTrainingIV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorNumberIII {
    //Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.
    public List<Integer> findAll(int[] array, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i : array){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > array.length / k){
                result.add(entry.getKey());
            }
        }
        return result;
    }

}
