package DPIV;

public class LongestCommonSubsequences {
    //Find the length of longest common subsequence of two given strings.
    public int longest(String source, String target){
        int[][] matrix = new int[source.length() + 1][target.length() + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    matrix[i][j] = 0;
                }
                else if(source.charAt(i) == target.charAt(j)){
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                else{
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
