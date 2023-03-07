import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        AllPathsFromSourcetoTarget allPathsFromSourcetoTarget = new AllPathsFromSourcetoTarget();
        allPathsFromSourcetoTarget.allPathsSourceTarget(graph);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if(graph == null || graph.length == 0){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        int target = graph.length;
        findAll(graph, list, result, 0, target);
        return result;
    }
    private void findAll(int[][] graph, List<Integer> list, List<List<Integer>> result, int index, int target){
        for(int i = 0; i < graph[index].length; i++){
            list.add(graph[index][i]);
            if(graph[index][i] != target){
                findAll(graph, list, result, graph[index][i], target);
            }
            else{
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
        }
    }
}
