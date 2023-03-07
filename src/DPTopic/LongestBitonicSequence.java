package DPTopic;

import java.util.Arrays;
import java.util.logging.Logger;

public class LongestBitonicSequence {
    // Given an array with all integers,  a sub-sequence of it is called Bitonic if it is first sorted in an ascending order,
    // then sorted in a descending order. How can you find the length of the longest bitonic subsequence.

    // 先左后右做dp
    public static void main(String[] args) {
        LongestBitonicSequence test = new LongestBitonicSequence();
        test.longestBitonic(new int[]{1,5,2,4,3});
    }

    public int longestBitonic(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int max = 0;
        int len = 1;
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int[] helper = new int[array.length + 1];
        helper[1] = array[0];
        left[0] = 1;
        right[array.length - 1] = 1;

        for(int i = 1; i < array.length; i++){
            if(array[i] > helper[len]){
                helper[++len] = array[i];
            }
            else{
                int index = Arrays.binarySearch(helper, 1, len, array[i]);
                if(index < 0){
                    index = - index - 1;
                    helper[index] = array[i];
                }
            }
            left[i] = len;
        }
        Arrays.fill(helper, 0);
        len = 1;
        helper[1] = array[array.length - 1];
        for(int i = array.length - 2; i >= 0; i--){
            if(array[i] > helper[len]){
                helper[++len] = array[i];
            }
            else{
                int index = Arrays.binarySearch(helper, 1, len, array[i]);
                if(index < 0) {
                    index = -index - 1;
                    helper[index] = array[i];
                }
            }
            right[i] = len;
        }

        for(int i = 0; i < array.length; i++){
            max = Math.max(max, left[i] + right[i] - 1);
        }
        return max;
    }
}
