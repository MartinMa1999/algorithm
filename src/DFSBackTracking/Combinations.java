package DFSBackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n == 0 || k == 0){
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> list = new ArrayList<>();
        findAll(n, k, 1, list, result);
        return result;
    }
    private void findAll(int n, int k, int start, List<Integer> list, List<List<Integer>> result){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        if(start > n){
            return;
        }

        for(int i = start; i <= n; i++){
            list.add(i);
            findAll(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
