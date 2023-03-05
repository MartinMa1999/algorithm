package DFSII;

import java.util.ArrayList;
import java.util.List;

public class TwoSubsetsWithMinDifference {
    //Given a set of n integers, divide the set in two subsets of n/2 sizes each
    // such that the difference of the sum of two subsets is as minimum as possible.
    public int minDifference(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int sum = sum(array);
        int[] result = new int[]{Integer.MAX_VALUE};
        List<Integer> list = new ArrayList<>();
        findAll(array, sum, result, 0, list);
        return result[0];
    }
    private void findAll(int[] array, int sum, int[] result, int index, List<Integer> list){
        if(list.size() == array.length / 2){
            result[0] = Math.min(result[0], Math.abs(sum(list) * 2 - sum));
            return;
        }

        if(index == array.length){
            return;
        }

        list.add(array[index]);
        findAll(array, sum, result, index + 1, list);
        list.remove(list.size() - 1);

        findAll(array, sum, result, index + 1, list);
    }
    private int sum(int[] array){
        int sum = 0;
        for(int num : array){
            sum += num;
        }
        return sum;
    }
    private int sum(List<Integer> list){
        int sum = 0;
        for(int num : list){
            sum += num;
        }
        return sum;
    }
}
