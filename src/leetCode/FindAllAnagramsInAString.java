package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    // leetcode 438
    // Given two strings s and p,
    // return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p == null || s == null  || p.length() > s.length()){
            return result;
        }
        int[] visited = new int[26];
        for(int i = 0; i < p.length(); i++){
            char tmp = p.charAt(i);
            visited[tmp - 'a']++;
        }
        int i = 0;
        for(; i < p.length(); i++){
            char tmp = s.charAt(i);
            visited[tmp - 'a']--;
            if(visited[tmp - 'a'] == 0){
                findIt(result, visited, 0);
            }
        }
        int len = p.length();
        for(; i < s.length(); i++){
            char tmp = s.charAt(i - len);
            visited[tmp - 'a']++;
            tmp = s.charAt(i);
            visited[tmp - 'a']--;
            if(visited[tmp - 'a'] == 0){
                findIt(result, visited, i - len + 1);
            }
        }

        return result;
    }

    private void findIt(List<Integer> result, int[] visited, int start){
        for(int num : visited){
            if(num != 0){
                return;
            }
        }

        result.add(start);
    }
}
