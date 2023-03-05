package DPII;

public class LargestSquareOf1s {
    //Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1)
    //每次都检查以当前index为右下的正方形最大有多大
    public int largest(int[][] matrix){
        // assume matrix cannot be null and length > 0
        int[][] helper = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0 || matrix[i][j] == 0){
                    helper[i][j] = matrix[i][j];
                }
                else{
                    helper[i][j] = Math.min(Math.min(helper[i - 1][j], helper[i - 1][j - 1]), helper[i][j - 1]);
                }
            }
        }
        return helper[helper.length - 1][helper[0].length - 1];
    }

}
