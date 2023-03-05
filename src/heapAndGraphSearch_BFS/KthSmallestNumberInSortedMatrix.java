package heapAndGraphSearch_BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    public int kSmallest(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0 || k > matrix.length * matrix[0].length){
            return Integer.MIN_VALUE;
        }
        PriorityQueue<MyCell> minHeap = new PriorityQueue<>(new Comparator<MyCell>() {
            @Override
            public int compare(MyCell o1, MyCell o2) {
                if(o1.val == o2.val){
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        minHeap.offer(new MyCell(0,0,matrix[0][0]));
        visited[0][0] = true;
        int count = 0;
        while(count + 1 < k){
            MyCell tmp = minHeap.poll();
            int i = tmp.i;
            int j = tmp.j;
            if(i + 1 < matrix.length && ! visited[i + 1][j]){
                minHeap.offer(new MyCell(i + 1, j, matrix[i + 1][j]));
                visited[i + 1][j] = true;
            }
            if(j + 1 < matrix[0].length && ! visited[i][j + 1]){
                minHeap.offer(new MyCell(i, j + 1, matrix[i][j + 1]));
                visited[i][j + 1] = true;
            }

            count++;
        }
        return minHeap.peek().val;
    }
}
class MyCell{
    int i;
    int j;
    int val;

    MyCell(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
