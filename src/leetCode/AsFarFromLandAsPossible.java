package leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    // leetcode 1162
    // Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
    // find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
    // If no land or water exists in the grid, return -1.

    public int maxDistance(int[][] grid) {  // 超时！traverse + bfs
        int result = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 0){
                    result = Math.max(result, findIt(grid, i, j));
                }
            }
        }
        return result;
    }

    private int findIt(int[][] grid, int i, int j){
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        boolean [][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int count = 0;
        int path = 0;
        breakpoint:
        while(! queue.isEmpty()){
            path++;
            int size = queue.size();
            while(size > 0){
                int[] tmp = queue.poll();
                count++;
                for(int[] direction : direct){
                    int x = tmp[0] + direction[0];
                    int y = tmp[1] + direction[1];
                    if(x >= 0 && x < n && y >= 0 && y < n){
                        if(grid[x][y] == 1){
                            break breakpoint;
                        }
                        if(! visited[x][y]){
                            visited[x][y] = true;
                            queue.offer(new int[]{x, y});
                        }
                    }

                }
                size--;
            }
        }

        return count == n * n? -1 : path;

    }

    public int dpWay(int[][] grid){
        final int INF = 999999;
        int n = grid.length;
        int[][] helper = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    helper[i][j] = 0;
                }
                else{
                    helper[i][j] = INF;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                if(i > 0){
                    helper[i][j] = Math.min(helper[i][j], helper[i - 1][j] + 1);
                }
                if(j > 0){
                    helper[i][j] = Math.min(helper[i][j], helper[i][j - 1] + 1);
                }

            }
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 1){
                    continue;
                }

                if(i < n - 1){
                    helper[i][j] = Math.min(helper[i][j], helper[i + 1][j] + 1);
                }
                if(j < n - 1){
                    helper[i][j] = Math.min(helper[i][j], helper[i][j + 1] + 1);
                }
            }
        }
        int result = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result = Math.max(result, helper[i][j]);
                }
            }
        }

        return result == INF? -1 : result;


    }

    
}
