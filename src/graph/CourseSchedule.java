package graph;

import java.util.*;

public class CourseSchedule {
    // There are a total of n courses you have to take, labeled from 0 to n - 1.
    //
    //Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
    // which is expressed as a pair: [0,1]
    //
    //Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0){
            return false;
        }

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] array : prerequisites){
            int i = array[0];
            int j = array[1];
            indegree[i]++;
            if(! map.containsKey(j)){
                map.put(j, new ArrayList<>());
            }
            map.get(j).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(! queue.isEmpty()){
            int tmp = queue.poll();
            if(map.containsKey(tmp)){
                List<Integer> list = map.get(tmp);
                for(int i : list){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        queue.offer(i);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}
