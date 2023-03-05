package crossTrainingDIY;

import java.util.ArrayDeque;
import java.util.Deque;

public class CompressString {
    // 如果只有一个字母就不用动
    public String compress(String input) {
        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int i = 1;
        int j = 1;
        while(j < array.length){
            if(array[j] != array[j - 1]){
                array[i++] = array[j++];
            }
            else{
                int count = 1;
                while(j < array.length && array[j] == array[j - 1]){
                    count++;
                    j++;
                }
                Deque<Integer> stack = new ArrayDeque<>();
                while(count > 0 || count % 10 != 0){
                    stack.offerFirst(count % 10);
                    count /= 10;
                }

                while(! stack.isEmpty()){
                    array[i++] = (char)(stack.pollFirst() + '0');
                }

            }
        }
        return new String(array, 0, i);
    }
}
