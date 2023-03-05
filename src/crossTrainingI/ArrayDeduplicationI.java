package crossTrainingI;

import java.util.Arrays;

public class ArrayDeduplicationI {
    public int[] deDup(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }
        int i = 1;
        int j = 1;
        while(j < array.length){
            if(array[j] != array[i - 1]){
                array[i++] = array[j++];
            }
            else{
                while (j < array.length && array[j] == array[i - 1]){
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, i);
    }
}
