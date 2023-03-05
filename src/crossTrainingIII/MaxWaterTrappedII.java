package crossTrainingIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {
    //Given a non-negative integer 2D array representing the heights of bars in a matrix.
    // Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix.
    // The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height.
    // Each bar has 4 neighboring bars to the left, right, up and down.
    public int max(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.val == o2.val){
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1){
                    minHeap.offer(new Element(matrix[i][j], i, j));
                }
            }
        }
        int[] result = new int[1];
        while(!minHeap.isEmpty()){
            Element tmp = minHeap.poll();
            visited[tmp.row][tmp.col] = true;
            findAll(matrix, visited, minHeap, tmp, result, tmp.row, tmp.col);
        }

        return result[0];
    }
    private void findAll(int[][] matrix, boolean[][] visited, PriorityQueue<Element> minHeap, Element tmp, int[] result, int x, int y){
        int val = tmp.val;
        for(int i = x - 1; i <= x + 1; i += 2){
            if(valid(matrix, visited, val, i, y)){
                visited[i][y] = true;
                result[0] += val - matrix[i][y];
                findAll(matrix, visited, minHeap, tmp, result, i, y);
            }
            else{
                if(i > 0 && i < matrix.length && ! visited[i][y]){{
                    minHeap.offer(new Element(matrix[i][y], i, y));
                }}
            }
        }
        for(int j = y - 1; j <= y + 1; j += 2){
            if(valid(matrix, visited, val, x, j)){
                visited[x][j] = true;
                result[0] += val - matrix[x][j];
                findAll(matrix, visited, minHeap, tmp, result, x, j);
            }
            else{
                if(j > 0 && j < matrix.length && ! visited[x][j]){{
                    minHeap.offer(new Element(matrix[x][j], x, j));
                }}
            }
        }
    }
    private boolean valid(int[][] matrix, boolean[][] visited, int val, int x, int y){
        return x > 0 && x < matrix.length && y > 0 && y < matrix[0].length && matrix[x][y] < val && ! visited[x][y];
    }
}
