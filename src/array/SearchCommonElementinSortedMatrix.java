package array;

import java.util.ArrayList;
import java.util.List;

public class SearchCommonElementinSortedMatrix {
    // Given a 2D integer matrix, where every row is sorted in ascending order.
    // How to find a common element in all rows. If there is no common element, then returns -1.

    public int search(int[][] matrix) {
        if(matrix.length == 1){
            return -1;
        }
        int[] tmp = matrix[0];
        for(int i = 1; i < matrix.length; i++){
            tmp = compare(tmp, matrix[i]);
        }
        return tmp.length > 0 ? tmp[0] : -1;
    }
    private int[] compare(int[] tmp, int[] array){
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < tmp.length && j < array.length){
            if(tmp[i] < array[j]){
                i++;
            }
            else if(tmp[i] == array[j]){
                list.add(tmp[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        int[] result = new int[list.size()];
        for(int k = 0; k < result.length; k++){
            result[k] = list.get(k);
        }
        return result;
    }
}
