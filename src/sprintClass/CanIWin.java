package sprintClass;

public class CanIWin {
    // There is an array of positive integers, in which each integer represents a piece of Pizza’s size,
    // you and your friend take turns to pick pizza from either end of the array.
    // The winner is the one who gets larger total sum of all pizza or whoever starts first if there is a tie.
    // Return whether you will win the game if you start first.

    // 因为是必胜策略，所以每次都要考虑，当我拿的时候，就要考虑两种拿法哪个最大；当另一个人拿的时候，就要考虑他的两种拿法哪个会让我拿到的最少，所以
    // 在考虑我拿的时候，就要比较max，在考虑他拿的两种情况的时候，就要找两种的min 
    public boolean canWin(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int[][] matrix = new int[nums.length][nums.length];
        for(int j = 0; j < matrix.length; j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    matrix[i][j] = nums[j];
                }
                else if(j - i == 1){
                    matrix[i][j] = Math.abs(nums[i] - nums[j]);
                }
                else{
                    int tmp1 = Math.min(nums[i] - nums[i + 1] + matrix[i + 2][j], nums[i] - nums[j] + matrix[i + 1][j - 1]);
                    int tmp2 = Math.min(nums[j] - nums[i] + matrix[i + 1][j - 1], nums[j] - nums[j - 1] + matrix[i][j - 2]);
                    matrix[i][j] = Math.max(tmp1, tmp2);
                }
            }
        }

        return matrix[0][matrix.length - 1] >= 0;
    }
}
