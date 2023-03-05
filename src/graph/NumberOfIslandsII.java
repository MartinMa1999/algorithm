package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslandsII {
    // A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which
    // turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of
    // islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent
    // lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water and the
    // given list of positions do not duplicate.

    // 每次放一个进去都看一下四周有没有已经存在的陆地

    public List<Integer> numIslands(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0 || positions == null || positions[0].length == 0){
            return result;
        }

        int[][] matrix = new int[m][n];
        for(int[] array : positions){
            int x = array[0];
            int y = array[1];
            if(result.isEmpty()){
                result.add(1);
            }
            else{
                int area = findNeighbors(x, y, matrix);
                int tmp = result.get(result.size() - 1);

                result.add(tmp - area + 1);
            }
            matrix[x][y] = 1;
        }
        return result;
    }
    private int findNeighbors(int x, int y, int[][] matrix){
        int result = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        Queue<int[]> queue = new ArrayDeque<>();

        if(x - 1 >= 0 && matrix[x - 1][y] == 1 && ! visited[x - 1][y]){
            result++;
            visited[x - 1][y] = true;
            queue.offer(new int[]{x - 1, y});
            while(! queue.isEmpty()){
                int[] tmp = queue.poll();
                int i = tmp[0];
                int j = tmp[1];
                if(i - 1 >= 0 && matrix[i - 1][j] == 1 && ! visited[i - 1][j]){
                    queue.offer(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if(i + 1 < matrix.length && matrix[i + 1][j] == 1 && ! visited[i + 1][j]){
                    queue.offer(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if(j - 1 >= 0 && matrix[i][j - 1] == 1 && ! visited[i][j - 1]){
                    queue.offer(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                if(j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && ! visited[i][j + 1]){
                    queue.offer(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
            }
        }

        if(x + 1 < matrix.length && matrix[x + 1][y] == 1 && ! visited[x + 1][y]){
            result++;
            visited[x + 1][y] = true;
            queue.offer(new int[]{x + 1, y});
            while(! queue.isEmpty()){
                int[] tmp = queue.poll();
                int i = tmp[0];
                int j = tmp[1];
                if(i - 1 >= 0 && matrix[i - 1][j] == 1 && ! visited[i - 1][j]){
                    queue.offer(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if(i + 1 < matrix.length && matrix[i + 1][j] == 1 && ! visited[i + 1][j]){
                    queue.offer(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if(j - 1 >= 0 && matrix[i][j - 1] == 1 && ! visited[i][j - 1]){
                    queue.offer(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                if(j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && ! visited[i][j + 1]){
                    queue.offer(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
            }
        }

        if(y - 1 >= 0 && matrix[x][y - 1] == 1 && ! visited[x][y - 1]){
            result++;
            visited[x][y - 1] = true;
            queue.offer(new int[]{x, y - 1});
            while(! queue.isEmpty()){
                int[] tmp = queue.poll();
                int i = tmp[0];
                int j = tmp[1];
                if(i - 1 >= 0 && matrix[i - 1][j] == 1 && ! visited[i - 1][j]){
                    queue.offer(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if(i + 1 < matrix.length && matrix[i + 1][j] == 1 && ! visited[i + 1][j]){
                    queue.offer(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if(j - 1 >= 0 && matrix[i][j - 1] == 1 && ! visited[i][j - 1]){
                    queue.offer(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                if(j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && ! visited[i][j + 1]){
                    queue.offer(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
            }
        }
        if(y + 1 < matrix[0].length && matrix[x][y + 1] == 1 && ! visited[x][y + 1]){
            result++;
            visited[x][y + 1] = true;
            queue.offer(new int[]{x, y + 1});
            while(! queue.isEmpty()){
                int[] tmp = queue.poll();
                int i = tmp[0];
                int j = tmp[1];
                if(i - 1 >= 0 && matrix[i - 1][j] == 1 && ! visited[i - 1][j]){
                    queue.offer(new int[]{i - 1, j});
                    visited[i - 1][j] = true;
                }
                if(i + 1 < matrix.length && matrix[i + 1][j] == 1 && ! visited[i + 1][j]){
                    queue.offer(new int[]{i + 1, j});
                    visited[i + 1][j] = true;
                }
                if(j - 1 >= 0 && matrix[i][j - 1] == 1 && ! visited[i][j - 1]){
                    queue.offer(new int[]{i, j - 1});
                    visited[i][j - 1] = true;
                }
                if(j + 1 < matrix[0].length && matrix[i][j + 1] == 1 && ! visited[i][j + 1]){
                    queue.offer(new int[]{i, j + 1});
                    visited[i][j + 1] = true;
                }
            }
        }
        return result;
    }
}
