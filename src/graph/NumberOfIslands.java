package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    // Given a 2d grid map of 1s (land) and 0s (water), count the number of islands.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by water.

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(valid(visited, grid, i, j)){
                    result += 1;
                }
            }
        }
        return result;
    }
    private boolean valid(boolean[][] visited, char[][] grid, int i, int j){
        if(visited[i][j] || grid[i][j] == '0'){
            return false;
        }

        visited[i][j] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while(! queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            if(x - 1 >= 0 && ! visited[x - 1][y] && grid[x - 1][y] == '1'){
                queue.offer(new int[]{x - 1, y});
                visited[x - 1][y] = true;
            }
            if(x + 1 < grid.length && ! visited[x + 1][y] && grid[x + 1][y] == '1'){
                queue.offer(new int[]{x + 1, y});
                visited[x + 1][y] = true;
            }
            if(y - 1 >= 0 && ! visited[x][y - 1] && grid[x][y - 1] == '1'){
                queue.offer(new int[]{x, y - 1});
                visited[x][y - 1] = true;
            }
            if(y + 1 < grid[0].length && ! visited[x][y + 1] && grid[x][y + 1] == '1'){
                queue.offer(new int[]{x, y + 1});
                visited[x][y + 1] = true;
            }
        }
        return true;
    }

}
