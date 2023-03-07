package leetCode;

import java.util.*;

public class JumpGameIV {
    // leetcode 1345
    public int minJumps(int[] arr) {
        if(arr == null || arr.length <= 1){
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(! map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[arr.length];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(arr.length - 1);
        visited[arr.length - 1] = true;
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int index = queue.poll();
                if(index - 1 == 0){
                    return count + 1;
                }
                else if(! visited[index - 1]){
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }

                if(index + 1 < arr.length && ! visited[index + 1]){
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }

                List<Integer> list = map.get(arr[index]);
                for(int i : list){
                    if(i == 0){
                        return count + 1;
                    }
                    if(! visited[i]){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
                size--;
            }
            count++;
        }
        return -1;
    }
}
