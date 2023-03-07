package leetCode;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    // leetcode 567
    // Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    //
    //In other words, return true if one of s1's permutations is the substring of s2.

    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }

        if(s1.length() > s2.length()){
            return false;
        }

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char tmp = s1.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            count++;
        }
        int i = 0;
        for (; i < s1.length(); i++){
            char tmp = s2.charAt(i);
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) - 1);
                if(map.get(tmp) >= 0){
                    count--;
                    if(map.get(tmp) == 0 && count == 0){
                        return true;
                    }
                }
            }
        }
        int len = s1.length();
        for(; i < s2.length(); i++){
            char tmp = s2.charAt(i - len);
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) + 1);
                if(map.get(tmp) > 0){
                    count++;
                }
            }

            tmp = s2.charAt(i);
            if(map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) - 1);
                if(map.get(tmp) >= 0){
                    count--;
                    if(map.get(tmp) == 0 && count == 0){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
