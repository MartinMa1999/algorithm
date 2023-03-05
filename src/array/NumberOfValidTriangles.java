package array;

import java.util.Arrays;

public class NumberOfValidTriangles {
    // Given an unsorted array of positive integers.
    // Find the number of triangles that can be formed with three different array elements as three sides of triangles.

    public int numOfTriangles(int[] array) {
        Arrays.sort(array);
        int result = 0;
        for(int i = array.length - 1; i >= 2; i--){
            int tmp = findTwo(array, i - 1, array[i]);
            result += tmp;
        }
        return result;
    }
    private int findTwo(int[] array, int index, int target){
        int sum = 0;
        for(int i = 0; i < index; i++){
            for(int j = i + 1; j <= index; j++){
                if(array[j] + array[i] > target){
                    sum += index - j + 1;
                    break;
                }
            }
        }
        return sum;
    }
}
