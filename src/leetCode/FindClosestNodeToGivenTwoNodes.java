package leetCode;

import java.util.*;

public class FindClosestNodeToGivenTwoNodes { // 2360
    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes test = new FindClosestNodeToGivenTwoNodes();
        test.closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1}, 5, 6);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1 >= edges.length || node1 < 0 || node2 >= edges.length || node2 < 0){
            return -1;
        }
        if(node1 == node2){
            return node1;
        }
        int result = -1;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        boolean one = false;
        boolean two = false;

        set1.add(node1);
        set2.add(node2);
        int cur1 = node1;
        int cur2 = node2;
        if(cur1 == -1){
            one = true;
        }
        if(cur2 == -1){
            two = true;
        }
        while(! one || ! two){
            if(! one){
                cur1 = edges[cur1];
                if(set2.contains(cur1)){
                    result = cur1;
                }
                else if(set1.contains(cur1) || cur1 == -1){
                    one = true;
                }
                else{
                    set1.add(cur1);
                }
            }

            if(! two){
                cur2 = edges[cur2];
                if(set1.contains(cur2)){
                    if(result == -1){
                        result = cur2;
                    }
                    else {
                        result = Math.min(result, cur2);
                    }
                }
                else if (set2.contains(cur2) || cur2 == -1){
                    two = true;
                }
                else{
                    set2.add(cur2);
                }
            }

            if(result != -1){
                break;
            }
        }

        return result;
    }

    public int theBest(int[] edges, int node1, int node2) { // 相当于先把所有点的距离直接写出来，然后再traverse所有的点并且比较距离。但是其实最好的办法是一边遍历一边找，效率最高，但是while loop的条件不好设置
        int[] array1 = findAll(edges, node1);
        int[] array2 = findAll(edges, node2);
        int result = -1;
        int distance = edges.length;
        for(int i = 0; i < edges.length; i++){
            int tmp = Math.max(array1[i], array2[i]);
            if(tmp < distance){
                distance = tmp;
                result = i;
            }
        }

        return result;
    }

    private int[] findAll(int[] edges, int node){
        int n = edges.length;
        int[] result = new int[n];
        Arrays.fill(result, n);
        for(int i = 0; node >= 0 && result[node] == n; node = edges[node]){
            result[node] = i++;
        }

        return result;
    }
}
