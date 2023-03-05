package DPIV;

public class CanIWinII {
    //There is an array of positive integers, in which each integer represents a piece of Pizza’s size,
    // you and your friend take turns to pick pizza from either end of the array.
    // our friend follows a simple strategy: He will always pick the larger one he could get during his turn.
    // The winner is the one who gets the larger total sum of all pizza. Return the max amount of pizza you can get.
    public int canIWin(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int[][] matrix = new int[array.length][array.length];
        for(int j = 0; j < array.length; j++){
            for(int i = j; i >=0; i--){
                if(i == j){
                    matrix[i][j] = array[i];
                }
                else if(i == j - 1){
                    matrix[i][j] = Math.max(array[j], array[i]);
                }
                else{
                    int tmp1 = array[j - 1] >= array[i] ? matrix[i][j - 2] : matrix[i + 1][j - 1]; //拿走了位于j位置的那块
                    tmp1 += array[j];
                    int tmp2 = array[j] > array[i + 1] ? matrix[i + 1][j - 1] : matrix[i + 2][j]; //拿走了位于i位置的那块
                    tmp2 += array[i];
                    matrix[i][j] = Math.max(tmp1, tmp2);
                }
            }
        }
        return matrix[0][matrix.length - 1];
    }
}
