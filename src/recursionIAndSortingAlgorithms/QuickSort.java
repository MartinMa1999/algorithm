package recursionIAndSortingAlgorithms;
import java.util.*;
class QuickSort {
    public int[] quickSort(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }

        return quickSort(array, 0, array.length - 1);
    }
    private int[] quickSort(int[] array, int left, int right){
        //when it comes to corner case, we don't need to do anything, so return array
        if(left >= right){
            return array;
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(array, pivotIndex, right);
        int i = left;
        int j = right - 1;

        while(i <= j){
            if(array[i] < array[right]){
                i++;
            }
            else{
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

        return array;
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
