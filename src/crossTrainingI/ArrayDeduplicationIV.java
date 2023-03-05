package crossTrainingI;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeduplicationIV {
    public int[] deDup(int[] array){
        if(array == null || array.length == 0){
            return array;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(array[0]);
        int j = 1;
        while(j < array.length){
            if(stack.isEmpty()) {
                stack.offerFirst(array[j++]);
            }
            else if(array[j] != stack.peekFirst()){
              stack.offerFirst(array[j++]);
            }
            else{
                while((j < array.length && array[j] == stack.peekFirst())){
                    j++;
                }
                stack.pollFirst();
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pollFirst();
        }
        return result;
    }
}
