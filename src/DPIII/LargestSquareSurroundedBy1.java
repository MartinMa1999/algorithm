package DPIII;

public class LargestSquareSurroundedBy1 {
    public int largest(int[][] matrix){
        // assume matrix cannot be null and length > 0
        int[][] row = new int[matrix.length][matrix[0].length];
        int[][] col = new int[matrix.length][matrix[0].length];
        findRow(row, matrix);
        findCol(col, matrix);

        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    int tmp = Math.min(row[i][j], col[i][j]);
                    while(tmp > 1){
                        if(row[i + tmp - 1][j] >= tmp && col[i][j + tmp - 1] >= tmp){
                            globalMax = Math.max(globalMax, tmp);
                            break;
                        }
                        tmp--;
                    }
                }
            }
        }
        return globalMax;
    }
    private void findRow(int[][] row, int[][] matrix){
        for(int i = 0; i < row.length; i++){
            for(int j = row[0].length - 1; j >= 0; j--){
                if(j == row[0].length - 1 || matrix[i][j] == 0){
                    row[i][j] = matrix[i][j];
                }
                else{
                    row[i][j] = row[i][j + 1] + 1;
                }
            }
        }
    }
    private void findCol(int[][] col, int[][] matrix){
        for(int i = col.length - 1; i >= 0; i--){
            for(int j = 0; j < col[0].length; j++){
                if(i == col.length - 1 || matrix[i][j] == 0){
                    col[i][j] = matrix[i][j];
                }
                else{
                    col[i][j] = col[i + 1][j] + 1;
                }
            }
        }
    }
}
