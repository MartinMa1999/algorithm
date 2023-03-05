package crossTrainingDIY;

import java.util.Arrays;

public class ArrayDeduplicationV {
    // Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements.
    // For each group of elements with the same value keep at most two of them
    public int[] deDup(int[] array) {
        if (array == null || array.length <= 2) {
            return array;
        }
        int i = 2;
        int j = 2;
        while (j < array.length) {
            if (array[j] == array[i - 1] && array[j] == array[i - 2]) {
                while (j < array.length && array[j] == array[i - 1] && array[j] == array[i - 2]) { // 因为没排序，所以必须检查所有前面的情况
                    j++;
                }
            } else {
                array[i++] = array[j++];
            }
        }
        return Arrays.copyOf(array, i);
    }
}