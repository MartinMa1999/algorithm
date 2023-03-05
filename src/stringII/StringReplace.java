package stringII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringReplace {
    //Given an original string input, and two strings S and T, from left to right replace all occurrences of S in input with T.
    public String replace(String input, String source, String target){
        //assume that non string is null and length > 0

        // use a list to save the beginning index of source in input
        Set<Integer> head = new HashSet<>();
        Set<Integer> tail = new HashSet<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == source.charAt(0)){
                int j = 0;
                while(j < source.length() && input.charAt(i + j) == source.charAt(j)){
                    j++;
                }
                if(j == source.length()){
                    head.add(i);
                    tail.add(i + j - 1);
                }
            }
        }
        char[] array = input.toCharArray();
        // in-place multiple
        if(target.length() < source.length()){
            int i = 0;
            int j = 0;
            while(j < input.length()){
                if(! head.contains(j)){
                    array[i++] = array[j++];
                }
                else{
                    int k = 0;
                    while(k < target.length()){
                        array[i++] = target.charAt(k++);
                    }
                    j += source.length();
                }
            }
            return new String(Arrays.copyOf(array, i));
        }


        char[] result = Arrays.copyOf(array, input.length() + tail.size() * (target.length() - source.length()));
        int i = array.length - 1;
        int j = result.length - 1;

        while(j > i){
            if(! tail.contains(i)){
                result[j--] = result[i--];
            }
            else{
                for(int k = target.length() - 1; k >= 0; k--){
                    result[j--] = target.charAt(k);
                }

                i -= source.length();
            }
        }
        return new String(result);
    }
}
