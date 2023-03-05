package leetCode;

import java.util.*;

public class FindClosestNodeToGivenTwoNodes {
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
}
