package stringII;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInASentenceI {
    // assume words are separated by single space and there are no heading or tailing white spaces
    public String reverseSentence(String s){
        if(s == null || s.length() == 0){
            return s;
        }

        char[] array = s.toCharArray();
        //reverse every word first, and then reverse the whole string
        int spaceIndex = 0;
        int head = 0;
        while(spaceIndex < array.length){
            if(array[spaceIndex] == ' '){
                reverse(array, head, spaceIndex - 1);
            }
            else if(spaceIndex > 0 && array[spaceIndex - 1] == ' '){
                head = spaceIndex;
            }
            spaceIndex++;
        }
        reverse(array, head, spaceIndex - 1);
        reverse(array, 0, array.length - 1);

        return new String(array);
    }
    private void reverse(char[] array, int i, int j){
        while(i < j){
            char tmp = array[i];
            array[i++] = array[j];
            array[j--] = tmp;
        }
    }

    public String betterWay(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        int pointer = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                stack.offerFirst(s.substring(pointer, i));
            }
            else if(i > 0 && s.charAt(i - 1) == ' '){
                pointer = i;
            }
            i++;

            if(i == s.length()){
                stack.offerFirst(s.substring(pointer, i));
            }
        }
        String result = null;
        while(! stack.isEmpty()){
            String tmp = stack.pollFirst();
            result = result + tmp;
            if(! stack.isEmpty()){
                result = result + " ";
            }

        }
        return result;
    }
}
