package crossTrainingDIY;

public class MergeStones {
    // We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers.
    // In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles.
    // We merge the piles of stones until we have only one pile left. Determine the minimum total cost.
    public int minCost(int[] stones) {// 非常类似与cutting wood，注意必须要三重遍历，因为要想清楚各种亮亮合并的可能
        int[] prefix = new int[stones.length + 1];
        int[][] helper = new int[stones.length + 1][stones.length + 1];
        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i - 1] + stones[i - 1];
        }

        for(int j = 2; j < helper.length; j++){
            for(int i = j - 1; i > 0; i--){
                if(i == j - 1){
                    helper[i][j] = prefix[j] - prefix[i - 1];
                }

                else{
                    helper[i][j] = Integer.MAX_VALUE;
                    int sum = prefix[j] - prefix[i - 1];
                    for(int k = i; k < j; k++){
                        helper[i][j] = Math.min(helper[i][j], helper[i][k] + helper[k + 1][j] + sum);
                    }
                }
            }
        }
        return helper[1][helper.length - 1];

    }
}
