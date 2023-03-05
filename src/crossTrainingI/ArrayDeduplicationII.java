package crossTrainingI;

import java.util.Arrays;

public class ArrayDeduplicationII {
    //Given a sorted integer array, remove duplicate elements.
    // For each group of elements with the same value keep at most two of them.
    public int[] deDup(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }

        if(array.length <= 2){
            return array;
        }

        int i = 2;
        int j = 2;
        while(j < array.length){
            if(array[j] != array[i - 2]){
                array[i++] = array[j++];
            }
            else{
                while (j < array.length && array[j] == array[i - 2]){
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, i);
    }

}
