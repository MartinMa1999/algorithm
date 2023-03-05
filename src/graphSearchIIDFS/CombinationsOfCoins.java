package graphSearchIIDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> allCombinations(int target, Integer[] coins){
        // suppose that target > 0 and coins.length > 0;

        Arrays.sort(coins,Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findAll(target, coins, 0, list, result);
        return result;
    }
    private void findAll(int target, Integer[] coins, int index, List<Integer> list, List<List<Integer>> result){
        if(index == coins.length - 1){
            if(target % coins[index] == 0){
                int num = target / coins[index];
                list.add(num);
                result.add(new ArrayList<>(list));//必须要deep copy，否则list会随着recursion改变值，因为只存了一个ref
                list.remove(index);//因为还在recursion里面，所以必须要吐出去，相当于提前判断了最后一层recursion的情况
            }
            return;
        }

        int tmp = target / coins[index];
        for(int i = 0; i <= tmp; i++){
            list.add(i);
            findAll(target - i * coins[index], coins, index + 1, list, result);
            list.remove(list.size() - 1);
        }

    }
}
