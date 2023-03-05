package crossTrainingII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //大概的逻辑就是先排序，然后走到一个点就找到后面所有可能等于target - array[i]的所有结果，如果有结果就加进去，如果没有就下一个
    public List<List<Integer>> threeSum(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }

        Arrays.sort(array);
        int i = 0;
        while(i < array.length - 3){
            if(i == 0 || array[i] == array[i - 1]){
                List<List<Integer>> tmp = getTwo(array, i + 1, target - array[i]);
                if(! tmp.isEmpty()){
                    for(List<Integer> list : tmp){
                        list.add(array[i]);
                        result.add(list);
                    }
                }
            }
            i++;
        }
        return result;
    }
    private List<List<Integer>> getTwo(int[] array, int i, int target) {
        List<List<Integer>> result = new ArrayList<>();
        while (i < array.length - 1) {
            int j = array.length - 1;
            if (array[i] + array[j] < target) {
                i++;
            } else if (array[i] + array[j] > target) {
                while (j > i + 1 && array[i] + array[j] > target) {
                    j--;
                }
                if (array[i] + array[j] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
                i++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                result.add(list);
                i++;
            }
        }
        return result;
    }
}
