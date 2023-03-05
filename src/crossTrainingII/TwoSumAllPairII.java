package crossTrainingII;

import java.util.*;

public class TwoSumAllPairII {
    public List<List<Integer>> twoSum(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : array) {
            if (set.contains(target - j)) {
                if (!map.containsKey(j) && !map.containsKey(target - j)) {
                    map.put(j, target - j);
                }
            }
            set.add(j);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> twoPointerWay(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }

        Arrays.sort(array);
        int i = 0;
        while(i < array.length - 1){
            if(i > 0 && array[i] == array[i - 1]){
                while(i < array.length - 1 && array[i] == array[i - 1]){
                    i++;
                }
            }
            else{
                int j = array.length - 1;
                while(j > i + 1 && array[i] + array[j] > target){//必须是i + 1,因为 j = i + 1的时候刚好停止
                    j--;
                }
                if(array[i] + array[j] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(array[i]);
                    list.add(array[j]);
                    result.add(list);
                }
                i++;
            }
        }
        return result;
    }
}
