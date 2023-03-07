package Advanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllPoints {
    // You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
    // You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
    //
    //Each 0 marks an empty land which you can pass by freely.
    //Each 1 marks a building which you cannot pass through.
    //Each 2 marks an obstacle which you cannot pass through.

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return Integer.MAX_VALUE;
        }

        if(! valid(grid)){
            return -1; // bug，有可能根本没有0
        }

        int[][] helper = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(! findPath(grid, helper, i, j)){
                        return -1;
                    };
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    min = Math.min(min, helper[i][j]);
                }
            }
        }
        return min;
    }
    private boolean findPath(int[][] grid, int[][] helper, int i, int j){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 1;
        queue.offer(new int[]{i, j});
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] tmp = queue.poll();
                List<int[]> list = findAll(tmp, visited, grid);
                for(int[] array : list){
                    int x = array[0];
                    int y = array[1];
                    helper[x][y] += count;
                    queue.offer(array);
                }
                size--;
            }
            count++;
        }

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(! visited[x][y] && grid[x][y] == 0){
                    return false;
                }
            }
        }

        return true;
    }

    private List<int[]> findAll(int[] array, boolean[][] visited, int[][] grid){
        List<int[]> result = new ArrayList<>();
        int i = array[0];
        int j = array[1];
        if(i - 1 >= 0 && grid[i - 1][j] == 0 && ! visited[i - 1][j]){
            visited[i - 1][j] = true;
            result.add(new int[]{i - 1, j});
        }
        if(i + 1 < grid.length && grid[i + 1][j] == 0 && ! visited[i + 1][j]){
            visited[i + 1][j] = true;
            result.add(new int[]{i + 1, j});
        }
        if(j - 1 >= 0 && grid[i][j - 1] == 0 && ! visited[i][j - 1]){
            visited[i][j - 1] = true;
            result.add(new int[]{i, j - 1});
        }
        if(j + 1 < grid[0].length && grid[i][j + 1] == 0 && ! visited[i][j + 1]){
            visited[i][j + 1] = true;
            result.add(new int[]{i, j + 1});
        }
        return result;
    }

    private boolean valid(int[][] grid){
        for(int[] array : grid){
            for(int i : array){
                if(i == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
