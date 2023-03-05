package finalExam;

import java.util.Arrays;

public class PackingUpSwags {
    public int findMin(int num){
        int[] helper = new int[num + 1];
        Arrays.fill(helper, Integer.MAX_VALUE);
        helper[0] = 0;
        for(int i = 1; i < helper.length; i++){
            for(int j = 1; j * j <= i; j++){//考虑了所有右边是平方的可能性
                helper[i] = Math.min(helper[i], helper[i - j * j] + 1);
            }
        }

        return helper[num];
    }

    // TC = O(n ^ 1.5) ， 遍历 i 用 n，遍历 j 用 sqrt(n)
}
