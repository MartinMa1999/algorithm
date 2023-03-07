package leetCode;

import java.util.HashMap;
import java.util.Map;

public class FindTheTownJudge {
    // In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
    //
    //If the town judge exists, then:
    //
    //The town judge trusts nobody.
    //Everybody (except for the town judge) trusts the town judge.
    //There is exactly one person that satisfies properties 1 and 2.
    //You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
    //
    //Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
    public static void main(String[] args) {
    }
    public int findJudge(int n, int[][] trust) {
        if(n == 0 || n == 1){
            return n;
        }

        boolean[] visited = new boolean[n];
        for(int[] array : trust){
            int tmp = array[0];
            visited[tmp - 1] = true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                map.put(i + 1, 0);
            }
        }

        for(int[] array: trust){
            if(map.containsKey(array[1])){
                map.put(array[1], map.get(array[1]) + 1);
                if(map.get(array[1]) == n - 1){
                    return array[1];
                }
            }
        }

        return -1;

    }
}
