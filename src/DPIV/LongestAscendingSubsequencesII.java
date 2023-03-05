package DPIV;

import java.util.Arrays;

public class LongestAscendingSubsequencesII {
    public int[] longest(int[] array){
        if (array == null || array.length == 0) {
            return new int[]{};
        }

        int[] helper = new int[array.length + 1];
        int[] dp = new int[array.length + 1];
        int len = 1;
        helper[1] = array[0];
        dp[1] = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > helper[len]){
                helper[++len] = array[i];
                dp[i + 1] = len;
            }
            else{
                int index = Arrays.binarySearch(helper, 0, len, array[i]);
                if(index < 0){
                    index = - index - 1;
                    helper[index] = array[i];
                    dp[i + 1] = index;//记录下来每次改变的值在helper里面的位置，然后从后往前找改变的最后一个数
                }
            }
        }
        int[] result = new int[len];
        for(int i = array.length - 1; i >= 0; i--){
            if(dp[i + 1] == len){
                result[len - 1] = array[i];
                len--;
            }
        }
        return result;
    }
}
