package DPIII;

public class LongestCrossOf1s {
    public int longest(int[][] matrix){
        // assume matrix cannot be null and length > 0
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        int[][] right = new int[row][col];
        int[][] up = new int[row][col];
        int[][] down = new int[row][col];

        findLeft(left ,matrix);
        findRight(right, matrix);
        findUp(up, matrix);
        findDown(down, matrix);

        int globalMax = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int tmp = Math.max(Math.max(left[i][j], right[i][j]), Math.max(up[i][j], down[i][j]));
                globalMax = Math.max(globalMax,tmp);
            }
        }
        return globalMax;
    }
    private void findLeft(int[][] left, int[][] matrix){
        for(int i = 0; i < left.length; i++){
            for(int j = 0; j < left[0].length; j++){
                if(j == 0 || matrix[i][j] == 0){
                    left[i][j] = matrix[i][j];
                }
                else{
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }
    }
    private void findRight(int[][] right, int[][] matrix){
        for(int i = 0; i < right.length; i++){
            for(int j = right[0].length - 1; j >= 0; j--){
                if(j == right[0].length - 1 || matrix[i][j] == 0){
                    right[i][j] = matrix[i][j];
                }
                else{
                    right[i][j] = matrix[i][j + 1] + 1;
                }
            }
        }
    }

    private void findUp(int[][] up, int[][] matrix){
        for(int i = 0; i < up.length; i++){
            for(int j = 0; j < up[0].length; j++){
                if(i == 0 || matrix[i][j] == 0){
                    up[i][j] = matrix[i][j];
                }
                else{
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
        }
    }
    private void findDown(int[][] down, int[][] matrix){
        for(int i = down[0].length - 1; i >= 0; i--){
            for(int j = 0; j < down[0].length; j++){
                if(i == down[0].length - 1 || matrix[i][j] == 0){
                    down[i][j] = matrix[i][j];
                }
                else{
                    down[i][j] = matrix[i + 1][j] + 1;
                }
            }
        }
    }

}
