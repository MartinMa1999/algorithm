package recursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        SpiralOrderTraverseII test = new SpiralOrderTraverseII();
        test.iterative(matrix);
    }
    public List<Integer> iterative(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int offset = 0;
        List<Integer> result = new ArrayList<>();

        while(rowSize > 0 && colSize > 0){
            if(rowSize == 1){
                for(int i = offset; i <= colSize - 1 + offset; i++){
                    result.add(matrix[offset][i]);
                }
                break;
            }

            if(colSize == 1){
                for(int i = offset; i <= rowSize - 1 + offset; i++){
                    result.add(matrix[i][offset]);
                }
                break;
            }

            for(int i = offset; i < colSize - 1 + offset; i++){
                result.add(matrix[offset][i]);
            }
            for(int i = offset; i < rowSize - 1 + offset; i++){
                result.add(matrix[i][colSize - 1 + offset]);
            }
            for(int i = colSize - 1 + offset; i > offset; i--){
                result.add(matrix[rowSize - 1 + offset][i]);
            }
            for(int i = rowSize - 1 + offset; i > offset; i--){
                result.add(matrix[i][offset]);
            }
            rowSize -= 2;
            colSize -= 2;
            offset++;
        }

        return result;
    }


    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        spiral(result, row, col, 0, matrix);
        return result;
    }
    private void spiral(List<Integer> result, int row, int col, int offset, int[][] matrix){
        if(row == 0 || col == 0){
            return;
        }
        if(row == 1){
            int tmp = offset;
            while(offset <= col - 1 + offset){
                result.add(matrix[tmp][offset]);
                offset++;
            }
            return;
        }
        if(col == 1){
            int tmp = offset;
            while(offset <= row - 1 + offset){
                result.add(matrix[offset][tmp]);
                offset++;
            }
            return;
        }

        for(int i = offset; i < col - 1 + offset; i++){
            result.add(matrix[offset][i]);
        }
        for(int i = offset; i < row - 1 + offset; i++){
            result.add(matrix[i][col - 1 + offset]);
        }
        for(int i = col - 1 + offset; i > offset; i--){
            result.add(matrix[row - 1 + offset][i]);
        }
        for(int i = row - 1 + offset; i > offset; i--){
            result.add(matrix[i][offset]);
        }

        spiral(result, row - 2, col - 2, offset + 1, matrix);

    }

}
