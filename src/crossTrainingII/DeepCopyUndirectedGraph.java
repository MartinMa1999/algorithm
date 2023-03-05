package crossTrainingII;

import java.util.*;

public class DeepCopyUndirectedGraph {
  public List<GraphNode> deepCopy(List<GraphNode> graph){
    List<GraphNode> result = new ArrayList<>();
    if(graph == null || graph.size() == 0){
      return result;
    }
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for(GraphNode node : graph){
      copy(node, map, result);
    }
    return result;
  }

  private void copy(GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> result){
    if(map.containsKey(node)){
      return;
    }

    Queue<GraphNode> queue = new ArrayDeque<>();
    GraphNode newNode = new GraphNode(node.key);
    queue.offer(node);
    map.put(node, newNode);

    while(! queue.isEmpty()){
      GraphNode tmp = queue.poll();
      GraphNode cur = map.get(tmp);
      result.add(cur);
      for(GraphNode neighbor : tmp.neighbors){//每次都要检查tmp的neighbor而不是node的
        if(! map.containsKey(neighbor)){
          map.put(neighbor, new GraphNode(neighbor.key));
          queue.offer(neighbor);
        }
        cur.neighbors.add(map.get(neighbor));
      }
    }
  }

  public List<GraphNode> DFSMethod(List<GraphNode> graph){
    List<GraphNode> result = new ArrayList<>();
    if(graph == null || graph.size() == 0){
      return result;
    }
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for(GraphNode node : graph){
      DFS(node, map, result);
    }
    return result;
  }
  private GraphNode DFS(GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> result){
    if(map.containsKey(node)){
      return map.get(node);
    }

    GraphNode newNode = new GraphNode(node.key);
    map.put(node, newNode);
    for(GraphNode neighbor : node.neighbors){
      newNode.neighbors.add(DFS(neighbor, map, result));
    }
    result.add(newNode);
    return newNode;
  }
}

class GraphNode {
  public int key;
  public List<GraphNode> neighbors;
  public GraphNode(int key) {
    this.key = key;
    this.neighbors = new ArrayList<GraphNode>();
  }
}