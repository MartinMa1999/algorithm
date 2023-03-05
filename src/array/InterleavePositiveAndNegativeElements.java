package array;

public class InterleavePositiveAndNegativeElements {
    // Given an array with both positive and negative numbers in random order.
    // Shuffle the array so that positive and negative numbers are put in position with even and odd indices, respectively.
    //
    //If there are more positive/negative numbers, put them at the end of the array.
    // The ordering of positive/negative numbers does not matter.

    // 先partition，然后前后开始遍历，一个一个换，直到 i > j，此时说明正数比复数多且都走完了，所以不需要再走了；如果是没到这个情况，就有可能是换过去的正数都用完了，所以此时提前停止
    public int[] interleave(int[] array) {
        if(array.length == 0){
            return array;
        }

        // partition
        int i = 0;
        int j = array.length - 1;
        while(i <= j){
            if(array[i] > 0){
                i++;
            }
            else{
                swap(array, i, j);
                j--;
            }
        }

        i = 0;
        j = array.length - 1;
        while(i <= j){
            if(i % 2 != 0 && array[i] > 0){ // 换负数上来
                if(array[j] < 0){
                    swap(array, i, j);
                    j--;
                }
                else{ // 此时说明负数用完了，该停止了
                    break;
                }
            }
            else if(i % 2 == 0 && array[i] < 0){ // 此时走完了正数，要把之前换到后面的负数换回来
                if(j < array.length - 1){
                    swap(array, i, j + 1);
                    j++;
                }
                if(j == array.length - 1){ // 此时换完了所有能换的正数，所以该停下来了，剩下的都是负数了
                    break;
                }
            }
            i++;
        }
        return array;
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
