package graph;

import java.util.*;

public class MinimumHeightTrees {
    // For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
    // Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
    // Given such a graph, write a function to find all the MHTs and return a list of their root labels.

    // 如果针对每一个点都做搜索也可以做，但是很复杂；很明显位于graph中间的点最有可能是答案，所以用拓扑排序+BFS来找中间的点

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        if(n == 1){
            result.add(0);
            return result;
        }
        int[] indegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] array : edges){
            int i = array[0];
            int j = array[1];
            indegree[i]++;
            indegree[j]++;
            list.get(i).add(j);
            list.get(j).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }

        while(! queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                int num = queue.poll();
                tmp.add(num);
                for(int i : list.get(num)){
                    indegree[i]--;
                    if(indegree[i] == 1){
                        queue.offer(i);
                    }
                }
                size--;
            }
            if(queue.isEmpty()){
                result = tmp;
            }
        }
        return result;

    }
}
