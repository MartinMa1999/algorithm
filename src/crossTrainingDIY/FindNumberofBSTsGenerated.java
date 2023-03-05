package crossTrainingDIY;

public class FindNumberofBSTsGenerated {
    // Find the number of different Binary Search Trees generated from 1-n.

    public int findIt(int n){
        if(n == 0){
            return 1;
        }

        int[] helper = new int[n + 1];
        helper[0] = 1;
        helper[1] = 1;
        for(int i = 2; i < helper.length; i++){
            for(int j = 1; j <= i; i++){
                helper[i] += helper[j - 1] * helper[i - j];  // 实际上每一轮都是recursion，但是只和范围有关， j - 1是左边个数，i - j是右边个数
            }
        }
        return helper[n];
    }
}
