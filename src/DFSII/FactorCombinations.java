package DFSII;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> factorCombinations(int target){
        // suppose target > 0
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(target == 1){
            list.add(1);
            result.add(list);
            return result;
        }

        List<Integer> factor = new ArrayList<>();
        for(int i = 2; i < target; i++){
            if(target % i == 0){
                factor.add(i);
            }
        }

        findAll(target, list, result, factor, 0);
        return result;
    }
    private void findAll(int target, List<Integer> list, List<List<Integer>> result, List<Integer> factor, int index){
        if(index == factor.size()){
            if(target == 1){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        findAll(target, list, result, factor, index + 1);
        int tmp = factor.get(index);
        int count = 0;
        while(target % tmp == 0){
            list.add(tmp);
            target /= tmp;
            findAll(target, list, result, factor, index + 1);
            count++;
        }

        while(count > 0){
            list.remove(list.size() - 1);
            count--;
        }
    }
}
