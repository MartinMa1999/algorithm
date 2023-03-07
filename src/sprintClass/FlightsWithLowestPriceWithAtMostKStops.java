package sprintClass;

import java.util.*;

public class FlightsWithLowestPriceWithAtMostKStops {

    // Suppose there are m flights connecting n cities. Flight is represented by an int array int[] where the first
    // element is departure city, the second element is destination city and the third element is the price.
    //
    //Given a departure city src, a destination city dst, and most number of stops k,
    // return the lowest price of flights can take you from src to dst with at most k stops. If there is no such a route,
    // then return -1.

    public static void main(String[] args) {
        FlightsWithLowestPriceWithAtMostKStops test = new FlightsWithLowestPriceWithAtMostKStops();
        test.findCheapestPrice(6, new int[][]{{0,1,6},{0,3,8},{0,4,27},{0,5,19},{1,2,1},{1,3,2},{1,4,30},{1,5,28},{2,3,7},{2,5,25},{3,4,15},{3,5,23},{4,5,21}}, 0, 3, 25);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { // bfs，超内存
        if(src == dst){
            return 0;
        }

        if(flights == null || flights.length == 0 || flights[0].length == 0 || src < 0 || dst >= n){
            return - 1;
        }

        int result = Integer.MAX_VALUE;

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int[] array : flights){
            if(! map.containsKey(array[0])){
                map.put(array[0], new ArrayList<>());
            }
            map.get(array[0]).add(Arrays.asList(array[1], array[2]));
        }

        for(int[] array : flights){
            if(array[0] == src){
                if(array[1] == dst){
                    result = Math.min(result, array[2]);
                }
                else{
                    int tmp = findAll(array, map, dst, k);
                    result = Math.min(result, tmp);
                }

            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int findAll(int[] array, Map<Integer, List<List<Integer>>> map, int dst, int k){
        int start = array[0];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(array[1], array[2]));
        int result = Integer.MAX_VALUE;
        while(k > 0 && ! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                List<Integer> tmp = queue.poll();
                int mid = tmp.get(0);
                int cost = tmp.get(1);
                if(! map.containsKey(mid)){
                    size--;
                    continue;
                }
                List<List<Integer>> list = map.get(mid);
                for(List<Integer> list1 : list){
                    if(list1.get(0) == dst){
                        int newCost = cost + list1.get(1);
                        result = Math.min(result, newCost);
                    }
                    else{
                        int newMid = list1.get(0);
                        int newCost = list1.get(1);
                        queue.offer(Arrays.asList(newMid, newCost + cost));
                    }
                }
                size--;
            }
            k--;
        }

        return result;
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) { // dfs, 超时
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] array : flights){
            if(! map.containsKey(array[0])){
                map.put(array[0], new HashMap<>());
            }

            map.get(array[0]).put(array[1], array[2]);
        }

        int[] result = new int[]{Integer.MAX_VALUE};
        boolean[] visited = new boolean[n];
        visited[src] = true;
        findAll(map, k, src, dst, 0, visited, result);
        return result[0] == Integer.MAX_VALUE? -1 : result[0];
    }

    private void findAll(Map<Integer, Map<Integer, Integer>> map, int stop, int src, int dst, int cost, boolean[] visited, int[] result){
        if(src == dst){
            result[0] = Math.min(result[0], cost);
            return;
        }

        if(stop < 0){
            return;
        }
        if(map.get(src) == null){
            return;
        }
        Map<Integer, Integer> neighbors = map.get(src);
        for(Map.Entry<Integer, Integer> entry : neighbors.entrySet()){
            int des = entry.getKey();
            int cos = entry.getValue();
            if(!visited[des]){
                visited[des] = true;
                findAll(map, stop - 1, des, dst, cost + cos, visited, result);
                visited[des] = false;
            }

        }
    }

    public int findCheapestPriceBest(int n, int[][] flights, int src, int dst, int k) {

        // 用一个matrix存下来所有的可能性之后遍历

        int max = 10000 * 101 + 1;

        int[][] helper = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(helper[i], max);
        }

        helper[0][src] = 0;
        for(int t = 1; t < k + 2; t++){ // 这玩意表示走t步到某个des所需要的cost，因为k次停留相当于k+1个destination，所以算上最开始的额外一行就是k + 2行
            for(int[] flight : flights){ // 每次都把可能性放到表里，把所有的票traverse一次来算成本，最后只需要找不同步数能到des的min
                int j = flight[0];
                int i = flight[1];
                int cost = flight[2];

                helper[t][i] = Math.min(helper[t][i], helper[t - 1][j] + cost);
            }
        }

        int result = max;

        for(int i = 1; i < k + 2; i++){ // 最后需要遍历一下看看不同步数到des的距离
            result = Math.min(result, helper[i][dst]);
        }

        return result == max ? -1 : result;


    }
}
