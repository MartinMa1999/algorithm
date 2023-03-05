package array;

import java.util.Arrays;

public class SetMatrixZeroes {
    // Given a m x n matrix, if an element is 0, set its entire row and column to 0.

    // 用第一行第一列标记遍历所遇到的0所在行列
    public void setZero(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean col = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                col = true;
                break;
            }
        }
        boolean row = false;
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                row = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(col){
            Arrays.fill(matrix[0], 0);
        }
    }
}
