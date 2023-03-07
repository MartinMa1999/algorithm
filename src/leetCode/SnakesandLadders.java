package leetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakesandLadders {
    // leetCode 909

    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(new int[]{1, 0});
        while(! queue.isEmpty()) {
            int[] tmp = queue.poll();
            for(int i = 1; i <= 6; i++){
                int next = tmp[0] + i;
                if(next > n * n){
                    break;
                }

                int[] rc = findIt(next, n);
                if(board[rc[0]][rc[1]] > 0){
                    next = board[rc[0]][rc[1]];
                }

                if(next == n * n){
                    return tmp[1] + 1;
                }

                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, tmp[1] + 1});
                }
            }
        }
        return -1;
    }

    private int[] findIt(int num, int n){
        int r = (num - 1) / n;
        int c = (num - 1) % n;
        if(r % 2 == 1){
            c = n - 1 - c;
        }

        return new int[]{n - 1 - r, c};
    }

}
