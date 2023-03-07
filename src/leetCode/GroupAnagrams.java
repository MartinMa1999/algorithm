package leetCode;

import java.util.*;

public class GroupAnagrams {
    // leetcode 49
    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    //
    public List<List<String>> groupAnagrams(String[] strs) { // 直接排序之后比较str
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String str = new String(tmp);
            if(! map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) { // 通过计数的方法得到结果
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] array = new int[26];
            for(int i = 0; i < s.length(); i++){
                array[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < array.length; i++){
                int tmp = array[i];
                if(tmp > 0){
                    sb.append((char)(i + 'a'));
                    sb.append(tmp);
                }
            }

            String str = sb.toString();
            if(! map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
