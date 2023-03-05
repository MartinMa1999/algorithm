package DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeepDistanceForIdenticalDistances {
    //Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k],
    // such that the output integer array satisfy this condition:
    //Between each two i's, they are exactly i integers

    public int[] keepDistance(int k){
        // assume k > 0
        List<int[]> list = new ArrayList<>();
        int[] result = new int[k * 2];
        findAll(list, result, 1, k);
        if(list.size() == 0){
            return null;
        }
        return list.get(0);
    }
    private void findAll(List<int[]> list, int[] result, int index, int k){
        if(index == k + 1){
            list.add(Arrays.copyOf(result, result.length));
            return;
        }

        for(int i = 0; i < result.length - k - 1; i++){
            if(result[i] == 0 && result[i + k + 1] == 0){
                result[i] = result[i + k + 1] = index;
                findAll(list, result, index + 1, k);
                result[i] = result[i + k + 1] = 0;
            }
        }
    }
}
