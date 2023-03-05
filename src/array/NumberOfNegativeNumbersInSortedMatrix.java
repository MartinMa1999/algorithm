package array;

public class NumberOfNegativeNumbersInSortedMatrix {
    // Given a matrix of integers, each row is sorted in ascending order from left to right,
    // each column is also sorted in ascending order from top to bottom.
    //
    //Determine how many negative numbers in the matrix.

    public int negNumber(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int count = 0;
        int[] array = matrix[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                for(int j = 0; j < matrix.length; j++){
                    if(matrix[j][i] < 0){
                        count++;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        return count;
    }
}
