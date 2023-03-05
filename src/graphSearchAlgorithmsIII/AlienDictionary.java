package graphSearchAlgorithmsIII;

import java.util.*;

public class AlienDictionary {
    // 两个单词逐个比较字母，找第一个不同的字母就是顺序
    public String alienOrder(String[] words){
        Map<Character, List<Character>> rule = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        boolean[] valid = new boolean[]{true};
        for(String word : words){
            int length = word.length();
            for(int i = 0; i < length; i++){
                rule.put(word.charAt(i), new ArrayList<>());
            }
        }

        for(int i = 1; i < words.length && valid[0]; i++){
            findRule(words[i - 1], words[i], valid, rule, inDegree);
        }
        if(!valid[0]){
            return "";
        }
        Queue<Character> queue = new ArrayDeque<>();
        Set<Character> set = rule.keySet();
        for(char c : set){
            if(! inDegree.containsKey(c)){
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(! queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            List<Character> tmp = rule.get(c);
            for(char c1 : tmp){
                inDegree.put(c1, inDegree.get(c1) - 1);
                if(inDegree.get(c1) == 0){
                    queue.offer(c1);
                }
            }
        }
        return sb.length() == rule.size() ? sb.toString() : "";
    }
    private void findRule(String s1, String s2, boolean[] valid, Map<Character, List<Character>> rule, Map<Character, Integer> inDegree){
        int i = 0;
        while(i < s1.length() && i < s2.length()){
            if(s1.charAt(i) != s2.charAt(i)){
                inDegree.put(s2.charAt(i), inDegree.getOrDefault(s2.charAt(i), 0) + 1);
                rule.get(s1.charAt(i)).add(s2.charAt(i));
                break;
            }
            i++;
        }
        int length = Math.min(s1.length(), s2.length());
        if(i == length && s1.length() > s2.length()){
            valid[0] = false;
        }
    }
}
