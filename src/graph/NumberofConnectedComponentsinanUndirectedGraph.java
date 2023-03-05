package graph;

import java.util.*;

public class NumberofConnectedComponentsinanUndirectedGraph {
    // Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
    // write a function to find the number of connected components in an undirected graph.

    //其实就是算有多少块图

    public int countComponents(int n, int[][] edges) {
        if(n <= 1 || edges == null || edges.length == 0 || edges[0].length == 0){
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            if(! map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            if(! map.containsKey(edges[i][1])){
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int result = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(valid(visited, map, i)){
                result++;
            }
        }
        return result;
    }
    private boolean valid(boolean[] visited, Map<Integer, List<Integer>> map, int index){
        if(visited[index]){
            return false;
        }

        visited[index] = true;

        if(! map.containsKey(index)){
            return true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(index);
        while(! queue.isEmpty()){
            int tmp = queue.poll();
            List<Integer> list = map.get(tmp);
            for(int i : list){
                if(! visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return true;
    }
}
