package heapAndGraphSearch_BFS;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph){
        if(graph == null || graph.size() == 0){
            return false;
        }
        Map<GraphNode, Integer> map = new HashMap<>();
        for(GraphNode node : graph){
            if(! valid(node, map)){
                return false;
            }
        }
        return true;
    }
    private boolean valid(GraphNode node, Map<GraphNode, Integer> map){
        if(map.containsKey(node)){
            return true;
        }

        Queue<GraphNode> queue = new ArrayDeque<>();
        int num = 0;
        queue.offer(node);
        map.put(node, num);
        while(! queue.isEmpty()){
            GraphNode tmp = queue.poll();
            num = 1 - map.get(tmp);
            for(GraphNode neighbor : tmp.neighbors){
                if(! map.containsKey(neighbor)){
                    map.put(neighbor, num);
                    queue.offer(neighbor);
                }
                else if(map.get(neighbor) != num){
                    return false;
                }
            }
        }
        return true;
    }
}
class GraphNode{
    int val;
    List<GraphNode> neighbors;

    GraphNode(int val){
        this.val = val;
        neighbors = new ArrayList<GraphNode>();
    }
}
