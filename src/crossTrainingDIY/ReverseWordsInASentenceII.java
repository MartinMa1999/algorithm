package crossTrainingDIY;

import java.util.Arrays;

public class ReverseWordsInASentenceII {
    // Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
    public String reverseWords(String input) {
        if(input == null || input.length() == 0){
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        while(j < array.length && array[j] == ' '){
            j++;
        }
        while(j < array.length){
            if(array[j] != ' '){
                array[i++] = array[j++];
            }
            else{
                if(array[j - 1] != ' '){
                    array[i++] = array[j++];
                }
                else{
                    j++;
                }
            }
        }
        if(array[i - 1] == ' '){
            i--;
        }
        array = Arrays.copyOf(array, i);
        reverse(array, 0, array.length - 1);
        int begin = 0;
        for(i = 0; i < array.length; i++){
            if(array[i] == ' '){
                reverse(array, begin, i - 1);
                begin = i + 1;
            }

            if(i == array.length - 1){
                reverse(array, begin, i);
            }
        }
        return new String(array);
    }
    private void reverse(char[] array, int i, int j){
        while(i < j){
            char tmp = array[i];
            array[i++] = array[j];
            array[j--] = tmp;
        }
    }
}
