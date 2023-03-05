package hashTableAndStringI;

import java.util.Arrays;

public class RemoveAdjacentRepeatedCharactersI {
    //Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
    // assume input String is sorted in natural order
    public String deDup(String input){
        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int i = 1;
        int j = 1;

        while(j < array.length){
            if(array[j] == array[i - 1]){
                j++;
            }
            else{
                array[i++] = array[j++];
            }
        }

        return new String(Arrays.copyOf(array, i));
    }
}
