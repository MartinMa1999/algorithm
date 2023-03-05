package crossTrainingDIY;

import java.util.*;

public class PlaceToPutTheChairII {
    // Given a gym with k pieces of equipment without any obstacles.
    // Let’s say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost
    // from the chair to the k pieces of equipment is minimal. The gym is represented by a char matrix,
    // ‘E’ denotes a cell with equipment, ' ' denotes a cell without equipment.
    // The cost of moving from one cell to its neighbor(left, right, up, down) is 1. You can put chair on any cell in the gym.

    public List<Integer> putChair(char[][] gym) {
        List<Integer> result = Arrays.asList(-1, -1);
        int[][] helper = new int[gym.length][gym[0].length];
        int min = 0;
        for(int i = 0; i < gym.length; i++){
            for(int j = 0; j < gym[0].length; j++){
                if(gym[i][j] == 'E'){
                    findAll(gym, helper, i, j);
                }
            }
        }
        for(int i = 0; i < gym.length; i++){
            for(int j = 0; j < gym[0].length; j++){
                if(result.get(0) == -1){
                    result.set(0, i);
                    result.set(1, j);
                    min = helper[i][j];
                }
                else{
                    if(helper[i][j] < min){
                        result.set(0, i);
                        result.set(1, j);
                        min = helper[i][j];
                    }
                }
            }
        }
        return result;
    }
    private void findAll(char[][] gym, int[][] helper, int i, int j){
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        visited[i][j] = true;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(i, j));
        int cost = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                List<Integer> tmp = queue.poll();
                List<List<Integer>> list = findPath(tmp, visited);
                for(List<Integer> newPoint : list){
                    helper[newPoint.get(0)][newPoint.get(1)] += cost;
                    queue.offer(newPoint);
                }
                size--;
            }
            cost++;
        }
    }
    private List<List<Integer>> findPath(List<Integer> tmp, boolean[][] visited){
        int i = tmp.get(0);
        int j = tmp.get(1);
        List<List<Integer>> result = new ArrayList<>();
        if(i - 1 >= 0 && ! visited[i - 1][j]){
            result.add(Arrays.asList(i - 1, j));
            visited[i - 1][j] = true;
        }
        if(i + 1 < visited.length && ! visited[i + 1][j]){
            result.add(Arrays.asList(i + 1, j));
            visited[i + 1][j] = true;
        }
        if(j - 1 >= 0 && ! visited[i][j - 1]){
            result.add(Arrays.asList(i, j - 1));
            visited[i][j - 1] = true;
        }
        if(j + 1 < visited[0].length && ! visited[i][j + 1]){
            result.add(Arrays.asList(i, j + 1));
            visited[i][j + 1] = true;
        }

        return result;
    }
}
