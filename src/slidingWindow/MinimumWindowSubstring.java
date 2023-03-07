package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // Given a string S and a string T, find the minimum window in S which will contain all the characters in T
    //
    //Input: S = “ADOBECODEBANC”
    //
    //          T = “ABC”
    //
    //Output: “BANC”

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        test.minWindow("acbba","aab");
    }

    public String minWindow(String source, String target) {
        if(source == null || source.length() == 0 || target == null || target.length() == 0){
            return null;
        }
        int count = target.length();
        int start = 0;
        String result = null;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < target.length(); i++){
            char tmp = source.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int length = Integer.MAX_VALUE;
        boolean visited = false;
        for(int i = 0; i < source.length(); i++){
            char tmp = source.charAt(i);
            if(map.containsKey(tmp)){
                if(! visited){
                    visited = true;
                    start = i;
                    map.put(tmp, map.get(tmp) - 1);
                    count--;
                }
                else if(map.get(tmp) == 0){
                    while(source.charAt(start) != tmp){
                        char tmp1 = source.charAt(start);
                        if(map.containsKey(tmp1)){
                            map.put(tmp1, map.get(tmp1) + 1);
                        }
                        start++;
                    }
                    start++;
                    while(! map.containsKey(source.charAt(start))){
                        start++;
                    }
                }
                else{
                    map.put(tmp, map.get(tmp) - 1);
                    count--;
                    if(map.get(tmp) == 0){
                        if(count == 0){
                            String s = source.substring(start, i + 1);
                            if(s.length() < length){
                                result = s;
                                length = s.length();
                            }
                        }
                    }
                }

            }

        }
        return result;
    }
}
