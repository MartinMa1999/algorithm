package crossTrainingDIY;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStringI {
    // Two Strings are called isomorphic if the letters in one String can be remapped to get the second String.
    // Remapping a letter means replacing all occurrences of it with another letter.
    // The ordering of the letters remains unchanged. The mapping is two-way and no two letters may map to the same letter,
    // but a letter may map to itself. Determine if two given String are isomorphic.
    public boolean isomorphic(String source, String target) {
        if(source.length() == 0 && target.length() == 0){
            return true;
        }
        if(source.length() != target.length()){
            return false;
        }

        int i = 0;
        Map<Character, Character> map = new HashMap<>(); // 存对应的规则
        while(i < source.length()){
            if(! map.containsKey(source.charAt(i))){
                if(map.containsValue(target.charAt(i))){// 出现了多对一，一定是false，为了避免traverse，也可以在做一个反过来的map
                    return false;
                }
                else{
                    map.put(source.charAt(i), target.charAt(i));
                }
            }
            else{
                if(map.get(source.charAt(i)) != target.charAt(i)){ // 出现了一对多，一定是false
                    return false;
                }
            }
            i++;
        }
        return true;

    }
}
