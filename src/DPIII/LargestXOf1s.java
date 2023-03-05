package DPIII;

public class LargestXOf1s {
    public int largest(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] left = new int[row][col];
        int[][] right = new int[row][col];

        findLeft(left, matrix);
        findRight(right, matrix);

        int globalMax = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int tmp = Math.min(left[i][j], right[i][j]);
                globalMax = Math.max(globalMax, tmp);
            }
        }
        return globalMax;
    }
    private void findLeft(int[][] left, int[][] matrix){
        for(int i = 0; i < left.length; i++){
            for(int j = 0; j < left[0].length; j++){
                if(i == 0 || j == 0 || matrix[i][j] == 0){
                    left[i][j] = matrix[i][j];
                }
                else{
                    left[i][j] = left[i - 1][j - 1] + 1;
                }
            }
        }
        for(int i = left.length - 1; i >= 0; i--){
            for(int j = left[0].length - 1; j >= 0; j--){
                if(i == left.length - 1 || j == left[0].length - 1 || matrix[i][j] == 0){
                    left[i][j] = matrix[i][j];
                }
                else{
                    int tmp = left[i][j];
                    left[i][j] = Math.min(tmp, left[i + 1][j + 1] + 1);
                }
            }
        }
    }
    private void findRight(int[][] right, int[][] matrix){
        for(int i = 0; i < right.length; i++){
            for(int j = right[0].length - 1; j >= 0; j--){
                if(i == 0 || j == right[0].length - 1 || matrix[i][j] == 0){
                    right[i][j] = matrix[i][j];
                }
                else{
                    right[i][j] = right[i - 1][j + 1] + 1;
                }
            }
        }
        for(int i = right.length - 1; i >= 0; i--){
            for(int j = 0; j < right[0].length; j++){
                if(i == right.length - 1 || j == 0 || matrix[i][j] == 0){
                    right[i][j] = matrix[i][j];
                }
                else{
                    int tmp = right[i][j];
                    right[i][j] = Math.min(tmp, right[i + 1][j - 1] + 1);
                }
            }
        }
    }
}
