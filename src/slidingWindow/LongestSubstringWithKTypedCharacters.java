package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class LongestSubstringWithKTypedCharacters {
    // Given a string, return the longest contiguous substring that contains exactly k type of characters.
    //
    //Return null if there does not exist such substring.
    public static void main(String[] args) {
        LongestSubstringWithKTypedCharacters test = new LongestSubstringWithKTypedCharacters();
        test.longest("aabeeccccaaab",3);
    }

    public String longest(String input, int k) {
        if(input == null || input.length() == 0 || k <= 0){
            return null;
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        int count = 0;
        int length = 0;
        int start = 0;
        String result = null;
        for(int i = 0; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(count < k){
                if(! map.containsKey(tmp)){
                    map.put(tmp, new ArrayList<>());
                    count++;
                }
                map.get(tmp).add(i);

            }
            else{
                if(map.containsKey(tmp)){
                    continue;
                }
                else{
                    String s = input.substring(start, i);
                    if(s.length() > length){
                        length = s.length();
                        result = s;
                    }
                    start = findStart(map, start, input); // bug!! 必须用input
                    count--; // bug !每次用完了必须减去一个
                }
            }
        }
        String s = input.substring(start, input.length());
        if(s.length() > length){
            result = s; // bug !一定要注意最后还有可能一直没有超界，所以要算一下全部走完的情况
        }
        return result;
    }
    private int findStart(Map<Character, List<Integer>> map, int start, String s){
        int num = Integer.MAX_VALUE;
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.get(list.size() - 1) < num){
                num = list.get(list.size() - 1);
            }
        }
        for(int i = start; i <= num; i++){
            char tmp = s.charAt(i);
            map.get(tmp).remove(0);
            if(map.get(tmp).isEmpty()){
               map.remove(tmp);
            }

        }
        return num + 1;
    }
}
