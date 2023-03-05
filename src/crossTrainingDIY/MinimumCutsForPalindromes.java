package crossTrainingDIY;

import java.util.Arrays;

public class MinimumCutsForPalindromes {
    // Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
    // Determine the fewest cuts needed for a palindrome partitioning of a given string.
    public static void main(String[] args) {
        String s = new String("aaaaaabbabb");
        MinimumCutsForPalindromes test = new MinimumCutsForPalindromes();
        test.minCuts(s);
    }
    public int minCuts(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        boolean[][] matrix = new boolean[input.length()][input.length()];
        for(boolean[] array : matrix){
            Arrays.fill(array, true);
        }

        for(int j = 0; j < matrix.length; j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    matrix[i][j] = true;
                }
                else {
                    matrix[i][j] = matrix[i + 1][j - 1] && input.charAt(i) == input.charAt(j);
                }
            }
        }

        int[] helper = new int[input.length()];
        helper[0] = 0;
        for(int i = 1; i < input.length(); i++){
            int count = Integer.MAX_VALUE;
            if(matrix[0][i]){
                count = 0;
            }
            else{
                for(int j = 1; j <= i; j++){ // bug, 因为此时helper和string长度相同，因此matrix[j][i]就必须考虑j = i的情况
                    if(matrix[j][i]){
                        count = Math.min(count, helper[j - 1] + 1); //bug，此时说明从j到i是回文串，则判断j - 1的那个数
                    }
                }
            }
            helper[i] = count;
        }
        return helper[helper.length - 1];
    }
}
