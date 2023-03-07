package leetCode;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    // leetcode 787

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int max = 10000 * 101 + 1;

        int[][] helper = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(helper[i], max);
        }

        helper[0][src] = 0;
        for(int t = 1; t < k + 2; t++){
            for(int[] flight : flights){
                int j = flight[0];
                int i = flight[1];
                int cost = flight[2];

                helper[t][i] = Math.min(helper[t][i], helper[t - 1][j] + cost);
            }
        }

        int result = max;

        for(int i = 1; i < k + 2; i++){
            result = Math.min(result, helper[i][dst]);
        }

        return result == max ? -1 : result;


    }
}
