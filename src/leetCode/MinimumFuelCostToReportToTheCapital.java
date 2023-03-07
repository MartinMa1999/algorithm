package leetCode;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    // leetcode 2477


    // 大概逻辑就是把
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads == null || roads.length == 0){
            return 0;
        }
        int n = roads.length + 1;

        List<Integer>[] path = new List[n];
        for(int i = 0; i < path.length; i++){
            path[i] = new ArrayList<>();
        }

        for(int[] road : roads){
            path[road[0]].add(road[1]);
            path[road[1]].add(road[0]);
        }

        long[] result = new long[1];
        findAll(0, -1, seats, path, result);
        return result[0];
    }

    private int findAll(int cur, int fa, int seats, List<Integer>[] path, long[] result){
        int size = 1;
        for(int i : path[cur]){
            if(i != fa){
                size += findAll(i, cur, seats, path, result);
            }
        }

        if(cur > 0){
            result[0] += (size + seats - 1) / seats;  // 表示这么多人在这个点向前走一步需要多少油
        }

        return size;
    }
}
