package recursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverse {
    public static void main(String[] args) {
        SpiralOrderTraverse test = new SpiralOrderTraverse();
        int[][] matrix = new int[][]{{-85, 56, 37, 48}, {-25, -78, -29, 62}, {18,-60,-74,-84}, {90,44,5,1}};
        test.spiralOrderTraverse(matrix);
    }
    // suppose matrix is a square
    public List<Integer> spiralOrderTraverse(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int size = matrix.length;
        int offset = 0;
        spiral(result, size, offset, matrix);
        return result;
    }
    private void spiral(List<Integer> result, int size, int offset, int[][] matrix){
        if(size == 0){
            return;
        }
        if(size == 1){
            result.add(matrix[offset][offset]);
            return;
        }

        for(int i = offset; i < size - 1 + offset; i++){
            result.add(matrix[offset][i]);
        }
        for(int i = offset; i < size - 1 + offset; i++){
            result.add(matrix[i][size - 1 + offset]);
        }
        for(int i = size - 1 + offset; i > offset; i--){
            result.add(matrix[size - 1 + offset][i]);
        }
        for(int i = size - 1 + offset; i > offset; i--){
            result.add(matrix[i][offset]);
        }

        spiral(result, size - 2, offset + 1, matrix);
    }

    public List<Integer> iterativeWay(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int offset = 0;
        int size = matrix.length;
        while(size > 0){
            if(size == 1){
                result.add(matrix[offset][offset]);
                break;
            }

            for(int i = offset; i < size - 1 + offset; i++){
                result.add(matrix[offset][i]);
            }
            for(int i = offset; i < size - 1 + offset; i++){
                result.add(matrix[i][size - 1 + offset]);
            }
            for(int i = size - 1 + offset; i > offset; i--){
                result.add(matrix[size - 1 + offset][i]);
            }
            for(int i = size - 1 + offset; i > offset; i--){
                result.add(matrix[i][offset]);
            }
            size = size - 2;
            offset++;
        }

        return result;
    }
}
