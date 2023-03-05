package crossTrainingIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNumbersOfTwoArraysII {
    //there could be duplicate numbers
    public List<Integer> commonNumbers(int[] a, int[] b){
        Map<Integer, Integer> map = new HashMap<>();
        for(int nums : a){
            map.put(nums, map.getOrDefault(nums, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(int nums : b){
            if(map.containsKey(nums)){
                result.add(nums);
                map.put(nums, map.get(nums) - 1);
                if(map.get(nums) == 0){
                    map.remove(nums);
                }
            }
        }
        return result;
    }
}
