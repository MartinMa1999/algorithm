package BFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {
    // 纯BFS解题
    public int maxTrapped(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int j = 0; j < matrix[0].length; j++){
            minHeap.offer(new int[]{matrix[0][j], 0, j});
            minHeap.offer(new int[]{matrix[matrix.length - 1][j], matrix.length - 1, j});
            visited[0][j] = true;
            visited[matrix.length - 1][j] = true;
        }
        for(int i = 1; i <matrix.length - 1; i++){
            minHeap.offer(new int[]{matrix[i][0], i, 0});
            minHeap.offer(new int[]{matrix[i][matrix[0].length - 1], i, matrix[0].length - 1});
            visited[i][0] = true;
            visited[i][matrix[0].length - 1] = true;
        }

        int result = 0;
        while(! minHeap.isEmpty()){
            int[] tmp = minHeap.poll();
            List<int[]> neighbors = findNeighbors(tmp, visited);
            for(int[] array : neighbors){
                int x = array[0];
                int y = array[1];
                if(matrix[x][y] < tmp[0]){
                    result += tmp[0] - matrix[x][y];
                    matrix[x][y] = tmp[0];
                }

                minHeap.offer(new int[]{matrix[x][y], x, y});
            }
        }
        return result;
    }

    private List<int[]> findNeighbors(int[] tmp, boolean[][] visited){
        int i = tmp[1];
        int j = tmp[2];
        List<int[]> result = new ArrayList<>();
        if(i - 1 >= 0 && ! visited[i - 1][j]){
            visited[i - 1][j] = true;
            result.add(new int[]{i - 1, j});
        }
        if(i + 1 < visited.length && ! visited[i + 1][j]){
            visited[i + 1][j] = true;
            result.add(new int[]{i + 1, j});
        }
        if(j - 1 >= 0 && ! visited[i][j - 1]){
            visited[i][j - 1] = true;
            result.add(new int[]{i, j - 1});
        }
        if(j + 1 < visited[0].length && ! visited[i][j + 1]){
            visited[i][j + 1] = true;
            result.add(new int[]{i, j + 1});
        }
        return result;
    }
}