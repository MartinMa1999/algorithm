package DFSBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    // Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
    // where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.
    //
    //All numbers (including target) will be positive integers.
    //
    //Elements in a combination (a1, a2, … , ak) must be in non-descending order.
    //
    //The solution set must not contain duplicate combinations.

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        test.combinationSum(new int[]{1,2,3,6}, 12);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        int[] array = new int[candidates.length];
        int i = 0;
        int j = 0;
        while(j < candidates.length){
            if(i == 0 || candidates[j] != candidates[j - 1]){
                array[i++] = candidates[j++];
            }
            else if(candidates[j] == candidates[j - 1]){
                while(j < candidates.length && candidates[j] == candidates[j - 1]){
                    j++;
                }
            }
        }

        candidates = Arrays.copyOf(array, i);
        findAll(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }
    private void findAll(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int index){
        if(index == candidates.length - 1){
            if(target % candidates[index] == 0){ // bug!!
                int tmp = target / candidates[index];
                for(int i = 0; i < tmp; i++){
                    list.add(candidates[index]);
                }
                result.add(new ArrayList<>(list));
                for(int i = 0; i < tmp; i++){
                    list.remove(list.size() - 1);
                }
            }
            return;
        }

        int count = target / candidates[index];

        for(int i = 0; i < count; i++){
            list.add(candidates[index]);
            findAll(candidates, target - candidates[index] * (i + 1), list, result, index + 1); // i + 1 !!!!
        }
        for(int i = 0; i < count; i++){
            list.remove(list.size() - 1);
        }

        findAll(candidates, target, list, result, index + 1);
    }
}
