package DPII;

public class EditDistance {
    //Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

    public int editDistance(String one, String two){
        // assume both strings cannot be null and length > 0
        int[][] matrix = new int[one.length() + 1][two.length() + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 && j == 0){
                    matrix[i][j] = 0;
                }
                else if(i == 0){
                    matrix[i][j] = matrix[i][j - 1] + 1;
                }
                else if(j == 0){
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
                else{
                    if(one.charAt(i) == two.charAt(j)){
                        matrix[i][j] = matrix[i - 1][j - 1];
                    }
                    else{
                        matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]), matrix[i][j - 1]);
                    }
                }
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];

    }
}
