package leetCode;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    // leetcode 1129

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> red = new HashMap<>();
        Map<Integer, List<Integer>> blue  = new HashMap<>();
        for(int i = 0; i < redEdges.length || i < blueEdges.length; i++){
            if(i < redEdges.length){
                if(! red.containsKey(redEdges[i][0])){
                    red.put(redEdges[i][0], new ArrayList<>());
                }
                red.get(redEdges[i][0]).add(redEdges[i][1]);
            }

            if(i < blueEdges.length){
                if(! blue.containsKey(blueEdges[i][0])){
                    blue.put(blueEdges[i][0], new ArrayList<>());
                }
                blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
            }
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        findAll(new HashMap<>(red), new HashMap<>(blue), result);
        findAll(blue, red, result);
        return result;
    }

    private void findAll(Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2, int[] result){
        Queue<List<Integer>> queue = new ArrayDeque<>();
        if(map1.containsKey(0)){
            queue.offer(map1.get(0));
            map1.remove(0);
        }
        int step = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                if(step % 2 == 1){
                    findAll(queue, map2, result, step);
                }
                else{
                    findAll(queue, map1, result, step);
                }
                size--;
            }

            step++;
        }
    }

    private void findAll(Queue<List<Integer>> queue, Map<Integer, List<Integer>> map, int[] result, int step){
        List<Integer> tmp = queue.poll();
        for(int i : tmp){
            result[i] = result[i] == -1 ? step : Math.min(result[i], step);
            if(map.containsKey(i)){
                queue.offer(map.get(i));
                map.remove(i);

            }
        }
    }

}
