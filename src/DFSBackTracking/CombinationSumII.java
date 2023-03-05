package DFSBackTracking;

import java.util.*;

public class CombinationSumII {
    // Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C
    // where the candidate numbers sums toT. Each number in C may only be used once in the combination.
    //
    //All numbers (including target) will be positive integers.
    //
    //Elements in a combination (a1, a2, … , ak) must be in non-descending order.
    //
    //The solution set must not contain duplicate combinations.

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(num == null || num.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(num);
        findAll(num, target, new ArrayList<>(), result, 0);

        return result;
    }
    private void findAll(int[] num, int target, List<Integer> list, List<List<Integer>> result, int index){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(target < 0){
            return;
        }

        if(index == num.length){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(num[index]);
        findAll(num, target - num[index], list, result, index + 1);
        list.remove(list.size() - 1);

        while(index + 1< num.length && num[index + 1] == num[index]){ //注意如果出现重复，就必须用这个办法剪枝！！！！
            index++;
        }


        findAll(num, target, list, result, index + 1); // 这里的index + 1可能超界，所以base case必须是index = num.length
    }
}
