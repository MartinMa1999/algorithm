package graph;

import java.util.*;

public class DepthOfForest {
    // Given an integer array A representing a forest, such that, A[i] means the parent index of index i, if A[i] == -1,
    // it means index i is a root.
    //
    //Determine what is the depth of the forest, the depth of the forest is the maximum depth of the trees in the forest.

    // 必须要检查有一种可能是没有root但是存在循环，所以必须在得到高度之后再检查一下有没有循环
    // 如果走dfs，就相当于每个点都走一次dfs，如果遇到遇到循环就停下
    public int depth(int[] forest) {
        if(forest == null || forest.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < forest.length; i++){
            if(forest[i] == -1){
                queue.offer(i);
                set.add(i);
            }
            else{
                if(! map.containsKey(forest[i])){
                    map.put(forest[i], new ArrayList<>());
                }
                map.get(forest[i]).add(i);
            }
        }

        int count = 0;
        while(! queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                int tmp = queue.poll();
                if(map.containsKey(tmp)){
                    List<Integer> list = map.get(tmp);
                    for(int i : list){
                        if(! set.add(i)){
                            return -1;
                        }
                        queue.offer(i);
                    }
                }
                size--;
            }
            count++;
        }
        Set<Integer> tmp = new HashSet<>(map.keySet());
        for(int i : tmp){
            if(set.contains(i)){
                map.remove(i);
            }
        }

        for(int i : map.keySet()){
            if(! valid(i, map)){
                return -1;
            }
        }
        return count;
    }
    private boolean valid(int i, Map<Integer, List<Integer>> map){
        Set<Integer> set = new HashSet<>();
        set.add(i);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        while(! queue.isEmpty()){
            int tmp = queue.poll();
            if(map.containsKey(tmp)){
                List<Integer> list = map.get(tmp);
                for(int j : list){
                    if(! set.add(j)){
                        return false;
                    }
                    queue.offer(j);
                }
            }
        }
        return true;
    }

    public int DFS(int[] forest) {
        if(forest == null || forest.length == 0){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < forest.length; i++){
            if(forest[i] != -1){
                if(! map.containsKey(forest[i])){
                    map.put(forest[i], new ArrayList<>());
                }
                map.get(forest[i]).add(i);
            }
        }

        int max = 1;
        for(int i : forest){
            int[] num = new int[1];
            boolean valid = findAll(i, map, num, new HashSet<Integer>(), 1);
            if(! valid){
                return -1;
            }

            if(i >= 0 && i < forest.length && forest[i] == -1){
                max = Math.max(max, num[0]);
            }
        }
        return max;
    }
    private boolean findAll(int i, Map<Integer, List<Integer>> map, int[] max, Set<Integer> set, int level){
        if(! set.add(i)){
            return false;
        }

        if(! map.containsKey(i)){
            max[0] = Math.max(max[0], level);
            return true;
        }
        List<Integer> list = map.get(i);
        for(int j : list){
            if(! findAll(j, map, max, set, level + 1)){
                return false;
            }
        }

        return true;
    }
}
