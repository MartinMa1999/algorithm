package crossTrainingDIY;

import java.util.HashSet;
import java.util.Set;

public class ReverseOnlyVowels {
    //  Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.
    public String reverse(String input) {
        // assume only lower case
        if(input == null || input.length() == 0){
            return input;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] array = input.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(set.contains(array[i]) && set.contains(array[j])){
                char tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
            else if(set.contains(array[i])){
                j--;
            }
            else if(set.contains(array[j])){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        return new String(array);
    }
}
