package stringII;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    public int longest(String input){
        if(input == null || input.length() == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        int globalMax = 0;
        Set<Character> set = new HashSet<>();
        while(j < input.length()){
            if(set.add(input.charAt(j))){
                j++;
                globalMax = Math.max(globalMax, (j - i + 1));
            }
            else{
                while(input.charAt(i) != input.charAt(j)){
                    set.remove(input.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        return globalMax;
    }
}
