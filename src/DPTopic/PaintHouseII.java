package DPTopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaintHouseII {
    // There are a row of n houses, each house can be painted with one of the k colors.
    // The cost of painting each house with a certain color is different.
    // You have to paint all the houses such that no two adjacent houses have the same color.
    //
    //The cost of painting each house with a certain color is represented by a n x k cost matrix.
    // For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting
    // house 1 with color 2, and so on... Find the minimum cost to paint all houses.

    public static void main(String[] args) {
        PaintHouseII test = new PaintHouseII();
        int[][] matrix = new int[][]{{3,20,7,7,16,8,7,12,11,19,1}, {10,14,3,3,9,13,4,12,14,13,1}, {10,1,14,11,1,16,2,7,16,7,19},{13,20,17,15,3,13,8,10,7,8,9},{4,14,18,15,11,9,19,3,15,12,15},{14,12,16,19,2,12,13,3,11,10,9},{18,12,10,16,19,9,18,4,14,2,4}};
        test.minCostII(matrix);
    }

    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int[] array = costs[0];
        for(int i = 1; i < costs.length; i++){
            Map<Integer, List<Integer>> map = new TreeMap<>();
            for(int j = 0; j < array.length; j++){ // bug！！一定要考虑最小值可能有两个的情况
                if(! map.containsKey(array[j])){
                    map.put(array[j], new ArrayList<>());
                }
                List<Integer> list = map.get(array[j]);
                if(list.isEmpty()){
                    list.add(j);
                    list.add(1);
                }
                else{
                    int tmp = list.get(1);
                    list.set(1, tmp + 1);
                }

            }
            int min1 = 0;
            int index1 = 0;
            int min2 = 0;
            int count = 0;
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                if(count == 0){
                    min1 = entry.getKey();
                    if(entry.getValue().get(1) != 1){
                        min2 = min1;
                        break;
                    }
                    index1 = entry.getValue().get(0);
                    count++;
                }
                else if(count == 1){
                    min2 = entry.getKey();
                    count++;
                }
                else{
                    break;
                }
            }

            for(int j = 0; j < array.length; j++){
                if(j != index1){
                    array[j] = min1 + costs[i][j];
                }
                else{
                    array[j] = min2 + costs[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : array){
            min = Math.min(i, min);
        }
        return min;
    }
}
