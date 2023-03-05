package crossTrainingI;

public class RotateMatrix {
    public int[][] rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return matrix;
        }

        int size = matrix.length;
        int offset = 0;
        while(size > 1){
            for(int i = offset; i < size - 1 + offset; i++){
                int tmp = matrix[offset][i];
                matrix[offset][i] = matrix[size - 1 + offset * 2 - i][offset]; // 因为开始的第一个对应的index是size - 1 + offset, 因此当i = offset的时候，必须加一个offset
                matrix[size - 1 + offset * 2 - i][offset] = matrix[size - 1 + offset][size - 1 + offset * 2 - i];
                matrix[size - 1 + offset][size - 1 + offset * 2 - i] = matrix[i][size - 1 + offset];
                matrix[i][size - 1 + offset] = tmp;
            }
            offset++;
            size -= 2;
        }
        return matrix;
    }
}
