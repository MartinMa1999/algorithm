package BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BestMeetingPoint {
    // A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1,
    // where each 1 marks the home of someone in the group.
    // The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

    //方法和放椅子一样
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int[][] helper = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    findCost(helper, i, j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int[] array : helper){
            for(int i : array){
                min = Math.min(min, i);
            }
        }
        return min;
    }
    private void findCost(int[][] helper, int i, int j){
        boolean[][] visited = new boolean[helper.length][helper[0].length];
        visited[i][j] = true;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(i, j));
        int cost = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                List<Integer> tmp = queue.poll();
                int x = tmp.get(0);
                int y = tmp.get(1);
                if(x - 1 >= 0 && ! visited[x - 1][y]){
                    helper[x - 1][y] += cost;
                    visited[x - 1][y] = true;
                    queue.offer(Arrays.asList(x - 1, y));
                }
                if(x + 1 < helper.length && ! visited[x + 1][y]){
                    helper[x + 1][y] += cost;
                    visited[x + 1][y] = true;
                    queue.offer(Arrays.asList(x + 1, y));
                }
                if(y - 1 >= 0 && ! visited[x][y - 1]){
                    helper[x][y - 1] += cost;
                    visited[x][y - 1] = true;
                    queue.offer(Arrays.asList(x, y - 1));
                }
                if(y + 1 < helper[0].length && ! visited[x][y + 1]){
                    helper[x][y + 1] += cost;
                    visited[x][y + 1] = true;
                    queue.offer(Arrays.asList(x, y + 1));
                }
                size--;
            }
            cost++;
        }
    }
}
