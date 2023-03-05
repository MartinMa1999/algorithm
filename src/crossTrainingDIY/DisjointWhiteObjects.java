package crossTrainingDIY;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class DisjointWhiteObjects {
    // In a 2D black image there are some disjoint white objects with arbitrary shapes,
    // find the number of disjoint white objects in an efficient way.
    //By disjoint, it means there is no white pixels that can connect the two objects,
    // there are four directions to move to a neighbor pixel (left, right, up, down).
    // Black is represented by 1’s and white is represented by 0’s.
    // 就是leetcode里面的岛屿数量问题
    public int whiteObjects(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(findAll(matrix, visited, i, j)){
                        count++;
                    }

                }
            }
        }
        return count;
    }
    private boolean findAll(int[][] matrix, boolean[][] visited, int i, int j){
        if(visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        List<Integer> list = Arrays.asList(i, j);
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(list);
        while(! queue.isEmpty()){
            List<Integer> tmp = queue.poll();
            int x = tmp.get(0);
            int y = tmp.get(1);
            if(x - 1 >= 0 && matrix[x - 1][y] == 0 && ! visited[x - 1][y]){
                queue.offer(Arrays.asList(x - 1, y));
                visited[x - 1][y] = true;
            }
            if(x + 1 < matrix.length && matrix[x + 1][y] == 0 && ! visited[x + 1][y]){
                queue.offer(Arrays.asList(x + 1, y));
                visited[x + 1][y] = true;
            }
            if(y - 1 >= 0 && matrix[x][y - 1] == 0 && ! visited[x][y - 1]){
                queue.offer(Arrays.asList(x, y - 1));
                visited[x][y - 1] = true;
            }
            if(y + 1 < matrix[0].length && matrix[x][y + 1] == 0 && ! visited[x][y + 1]){
                queue.offer(Arrays.asList(x, y + 1));
                visited[x][y + 1] = true;
            }
        }
        return true;
    }
}
