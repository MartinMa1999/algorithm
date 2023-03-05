package DPIV;

import java.util.Arrays;

public class LongestAscendingSubsequence {
    //Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
    public int DP(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int[] helper = new int[array.length];
        helper[0] = 1;
        int globalMax = 0;
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    helper[i] = Math.max(array[j] + 1, helper[i]);
                }
            }
            globalMax = Math.max(globalMax, helper[i]);
        }
        return globalMax;
    }

    public int betterWay(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = 1;
        int[] helper = new int[]{array.length + 1};
        helper[0] = 0;
        helper[length] = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > helper[length]){
                helper[++length] = array[i];
            }
            else{
                int index = Arrays.binarySearch(helper, 1, length, array[i]);
                if(index < 0){
                    index = - index - 1;
                    helper[index] = array[i];
                }
            }
        }
        return length;
    }
}
