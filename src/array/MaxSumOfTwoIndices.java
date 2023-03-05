package array;

public class MaxSumOfTwoIndices {
    // Given an array with integers, find two indices i and j  (j>=i),  such that the value of A[i]+A[j]+ (j - i) is maximized.
    //
    //Return (i, j).

    public int[] maxSum(int[] array) {
        if(array == null || array.length == 0){
            return array;
        }

        int i = 0;
        int j = array.length - 1;
        int max = 0;
        int[] result = null;
        while(i <= j){
            int tmp = array[i] + array[j] + j - i;
            if(max < tmp){
                max = tmp;
                result = new int[]{i, j};
            }
            if(array[i] < array[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return result;
    }
}
