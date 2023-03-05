package graphSearchAlgorithmsIII;

import java.util.*;

public class CourseScheduleII {
    // Given the total number of courses and a list of prerequisite pairs,
    // return the ordering of courses you should take to finish all courses.
    public int[] findOrder(int numCourses, int[][] preRequisites){
        Map<Integer, List<Integer>> rule = new HashMap<>();//list存可以指向哪门课，表示这门课是哪些课的先修课
        Map<Integer, Integer> inDegree = new HashMap<>();//表示上这门课的先修课有多少门，如果没有先修课就不会创建
        for(int i = 0; i < numCourses; i++){
            rule.put(i, new ArrayList<>());
        }
        for(int[] tmp : preRequisites){
            inDegree.put(tmp[0], inDegree.getOrDefault(tmp[0], 0) + 1);// tmp[1]代表的是需要的先修课
            rule.get(tmp[1]).add(tmp[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = rule.keySet();
        List<Integer> list = new ArrayList<>();

        for(int i : set){
            if(inDegree.containsKey(i)){
                queue.offer(i);
            }
        }

        while(! queue.isEmpty()){
            int tmp = queue.poll();
            list.add(tmp);
            if(! rule.get(tmp).isEmpty()){
                for(int course : rule.get(tmp)){
                    inDegree.put(course, inDegree.get(course) - 1);
                    if(inDegree.get(tmp) == 0){
                        queue.offer(tmp);
                    }
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result.length == numCourses ? result : new int[]{};

    }

    public int[] betterWay(int numCourses, int[][] preRequisites){
        // assume input cannot be null and > 0
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> rule = new HashMap<>();
        for(int[] tmp : preRequisites){
            inDegree[tmp[0]]++;
            if(! rule.containsKey(tmp[1])){
                rule.put(tmp[1], new ArrayList<>());
            }
            rule.get(tmp[1]).add(tmp[0]);
        }
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(! queue.isEmpty()){
            int tmp = queue.poll();
            list.add(tmp);
            if(rule.get(tmp) != null){
                for(int num : rule.get(tmp)){
                    inDegree[num]--;
                    if(inDegree[num] == 0){
                        queue.offer(num);//num才是课程！！！！
                    }
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result.length == numCourses ? result : new int[]{};
    }
}
