package graphSearchAlgorithmsIII;

import java.util.*;

public class PlaceToPutTheChairI {
    // Given a gym with k pieces of equipment and some obstacles.
    // We bought a chair and wanted to put this chair into the gym such that
    // the sum of the shortest path cost from the chair to the k pieces of equipment is minimal.
    // The gym is represented by a char matrix, ‘E’ denotes a cell with equipment, ‘O’ denotes a cell with an obstacle,
    // 'C' denotes a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down)
    // if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1.
    // You can not put the chair on a cell with equipment or obstacle.
    public List<Integer> putChair(char[][] gym){
        // assume gym cannot be null and length > 0
        int[][] cost = new int[gym.length][gym[0].length];
        for(int i = 0; i < cost.length; i++){
            for(int j = 0; i < cost[0].length; j++){
                if(gym[i][j] == 'E'){
                    if(! findCost(gym, cost, i, j)){
                        return Arrays.asList(-1, -1);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < gym.length; i++){
            for(int j = 0; j < gym[0].length; j++){
                if(gym[i][j] == 'C'){
                    if(result.isEmpty()){
                        result = Arrays.asList(i, j);
                    }
                    else{
                        result = cost[result.get(0)][result.get(1)] < cost[i][j] ? result : Arrays.asList(i, j);
                    }
                }

            }
        }
        return result;
    }

    private boolean findCost(char[][] gym, int[][] cost, int i, int j){
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        Queue<List<Integer>> queue = new ArrayDeque<>();
        visited[i][j] = true;
        List<Integer> tmp = Arrays.asList(i, j);
        queue.offer(tmp);
        int count = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                tmp = queue.poll();
                List<List<Integer>> list = findPath(tmp, gym, visited);
                if(! list.isEmpty()){
                    for(List<Integer> newPoint : list){
                        cost[newPoint.get(0)][newPoint.get(1)] += count;
                        queue.offer(newPoint);
                    }
                }
                size--;
            }
            count++;
        }
        for(int x = 0; x < gym.length; x++){
            for (int y = 0; y < gym[0].length; y++){
                if(! visited[x][y] && gym[x][y] != 'O'){
                    return false;
                }
            }
        }
        return true;
    }

    private List<List<Integer>> findPath(List<Integer> tmp, char[][] gym, boolean[][] visited){
        List<List<Integer>> result = new ArrayList<>();
        int x = tmp.get(0);
        int y = tmp.get(1);

        if(x + 1 < gym.length && ! visited[x + 1][y] && gym[x + 1][y] != 'O'){
            result.add(Arrays.asList(x + 1, y));
            visited[x + 1][y] = true;
        }
        if(y + 1 < gym[0].length && ! visited[x][y + 1] && gym[x][y + 1] != 'O'){
            result.add(Arrays.asList(x, y + 1));
            visited[x][y + 1] = true;
        }
        if(x - 1 > 0 && ! visited[x - 1][y] && gym[x - 1][y] != 'O'){
            result.add(Arrays.asList(x - 1, y));
            visited[x - 1][y] = true;
        }
        if(y - 1 > 0 && ! visited[x][y - 1] && gym[x][y - 1] != 'O'){
            result.add(Arrays.asList(x, y - 1));
            visited[x][y - 1] = true;
        }
        return result;
    }
}
