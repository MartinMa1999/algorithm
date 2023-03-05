package graph;

import java.util.*;

public class GraphValidTree {
    // Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
    // write a function to check whether these edges make up a valid tree.

    //用一个matrix双向标记一下，因为用map标记不好删除；需要检查两种情况，一种是循环，另一种是有点不连着
    public boolean validTree(int n, int[][] edges){
        int[][] helper = new int[n][n];
        for(int[] array : edges){
            int i = array[0];
            int j = array[1];
            helper[i][j] = 1;
            helper[j][i] = 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(! queue.isEmpty()){
            int tmp = queue.poll();
            for(int i = 0; i < n; i++){
                if(helper[tmp][i] == 1){
                    if(visited[i]){
                        return false;
                    }

                    visited[i] = true;
                    helper[tmp][i] = 0;
                    helper[i][tmp] = 0;
                    queue.add(i);

                }
            }
        }
        for(boolean b : visited){
            if(! b){
                return false;
            }
        }
        return true;
    }
}
