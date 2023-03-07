package Advanced;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    // Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
    //
    //For example, Given s = “eceba”, T is "ece", return 3

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
        test.lengthOfLongestSubstringTwoDistinct("abd cdd");
    }

    public int lengthOfLongestSubstringTwoDistinct(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        String result = null;
        int length = 0;
        int start = 0;
        for(int i = 0; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(! map.containsKey(tmp)){
                if(map.size() < 2){
                    map.put(tmp, i);
                }
                else{
                    if(i - start > length){
                        result = input.substring(start, i);
                        length = result.length();
                    }


                    char old = input.charAt(start);
                    int index = map.get(old);

                    for(Map.Entry<Character, Integer> entry : map.entrySet()){
                        if(entry.getKey() != old){
                            if(entry.getValue() < index){
                                index = entry.getValue();
                            }

                        }
                    }
                    start = index + 1;
                    map.remove(old); // bug ! 记得删除和加上新的
                    map.put(tmp, i);

                }
            }
            else{
                map.put(tmp, i);
            }
        }

        return Math.max(length, input.length() - start); // bug! 有可能走到最后还是没有超过3个不同的字母
    }
}
