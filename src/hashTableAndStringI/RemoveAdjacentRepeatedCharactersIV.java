package hashTableAndStringI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RemoveAdjacentRepeatedCharactersIV {
    //Repeatedly remove all adjacent, repeated characters in a given string from left to right.
    //assume input string is not sorted
    public String deDup(String input){
        if(input == null || input.length() == 0){
            return null;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < input.length()){
            if(stack.isEmpty()){
                stack.offerFirst(input.charAt(i++));
            }
            else if(input.charAt(i) == stack.peekFirst()){
                while(i < input.length() && input.charAt(i) == stack.peekFirst()){
                    i++;
                }
                stack.pollFirst();
            }
            else{
                stack.offerFirst(input.charAt(i++));
            }
        }

        if(stack.isEmpty()){
            return new String("");
        }

        char[] result = new char[stack.size()];
        for(int j = 0; j < result.length; j++){
            result[result.length - 1 - j] = stack.pollFirst();
        }

        return new String(result);
    }

    public String deDup2(String input){
        if(input == null || input.length() == 0){
            return null;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;

        while(j < array.length){
            if(i == 0){
                array[i++] = array[j++];
            }
            else if(array[j] == array[i - 1]){
                while(j < array.length && array[j] == array[i - 1]){
                    j++;
                }
                i--;
            }
            else{
                array[i++] = array[j++];
            }
        }

        if(i == 0){
            return new String("");
        }

        return new String(Arrays.copyOf(array, i));


    }
}
