package string;


import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // Given a pattern and a string str, find if str follows the same pattern.
    // Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

    // 用dfs走所有的map组合，如果能找到一种匹配方法就可以，否则就return false
    public boolean wordPatternMatch(String pattern, String input) {
        if((pattern == null && input == null) || (pattern.length() == 0 && input.length() == 0)){
            return true;
        }
        if(pattern == null || input == null || pattern.length() == 0 || input.length() == 0){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        return dfs(pattern, input, map, 0, 0);
    }
    private boolean dfs(String pattern, String input, Map<Character, String> map, int i, int j){
        if(i == pattern.length() && j == input.length()){
            return true;
        }
        if(i == pattern.length() || j == input.length()){
            return false;
        }

        if(! map.containsKey(pattern.charAt(i))){
            for(int k = j + 1; k <= input.length(); k++){
                String tmp = input.substring(j, k);
                if(map.containsValue(tmp)){
                    continue; // bug !!如果遇到不同的字母指向相同的就直接跳过去，而不是直接return false
                }
                map.put(pattern.charAt(i), tmp);
                if(dfs(pattern, input, map, i + 1, k)){
                    return true;
                }
            }
            map.remove(pattern.charAt(i));
        }
        else{
            String tmp = map.get(pattern.charAt(i));
            int k = 0;
            while(k < tmp.length() && j + k < input.length()){
                if(tmp.charAt(k) != input.charAt(k + j)){
                    return false;
                }
                k++;
            }
            if(k < tmp.length()){
                return false;
            }

            return dfs(pattern, input, map, i + 1, j + k);
        }
        return false;
    }
}
