package graph;

public class CelebrityProblem {
    // Given an binary matrix of N * N (the only elements in the matrix are 0s and 1s), each of the indices represents one person.
    // matrix[i][j] = 1 if and only if person i knows person j (this is single direction, only if matrix[j][i] = 1 such that person j knows person i).
    //
    //Determine if there is one celebrity among all N persons, a celebrity is defined as
    //He does not know any other person.
    //All the other persons know him.

    // Return the celebrity's index if there exist one (there could be at most one celebrity, why?), return -1 otherwise.

    public int celebrity(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        for(int i = 0; i < matrix.length; i++){
            if(valid(matrix[i], i)){
                if(valid(matrix, i)){
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean valid(int[] array, int index){
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                if(i != index){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean valid(int[][] matrix, int index){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][index] == 0 && i != index){
                return false;
            }
        }
        return true;
    }
}
