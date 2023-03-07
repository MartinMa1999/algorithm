package DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class NumberOfGoodPaths { // leetcode 2421
    // There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
    //
    //You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
    //
    //A good path is a simple path that satisfies the following conditions:
    //
    //The starting node and the ending node have the same value.
    //All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
    //Return the number of distinct good paths.
    //
    //Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.

    public static void main(String[] args) {
        NumberOfGoodPaths numberOfGoodPaths = new NumberOfGoodPaths();
        int[] vals = new int[]{1,3,2,1,3};
        int[][] edges = new int[][]{{0,1},{0,2},{2,3},{2,4}};

        numberOfGoodPaths.numberOfGoodPaths(vals, edges);
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<Integer>[] neighbor = new ArrayList[n]; // 用来存邻居的
        Arrays.setAll(neighbor, tmp-> new ArrayList<>());

        for(int[] array : edges){ // 建图，找到每个节点的邻居
            int x = array[0];
            int y = array[1];
            neighbor[x].add(y);
            neighbor[y].add(x);
        }

        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int[] size = new int[n]; // 表示在同一块set上value和val[i]相同的节点个数
        Arrays.fill(size, 1); // 一开始都没连起来，都是自己一块

        Integer[] idx= IntStream.range(0,n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return vals[o1] - vals[o2];
            }
        });

        int result = n; // 因为一个节点是一块
        for(Integer i : idx){
            int value = vals[i];
            int parentIndex = findParent(parent, i);
            for(int j : neighbor[i]){
                int otherParent = findParent(parent, j);
                if(otherParent == parentIndex || vals[otherParent] > value){
                    continue;
                }
                if (vals[otherParent] == value){
                    result += size[parentIndex] * size[otherParent];
                    size[parentIndex] += size[otherParent];
                }
                parent[otherParent] = parentIndex;
            }
        }

        return result;
    }

    private int findParent(int[] parent, int i){
        if(parent[i] != i){
            parent[i] = findParent(parent, parent[i]);
        }

        return parent[i];
    }
}
