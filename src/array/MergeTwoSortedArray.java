package array;

public class MergeTwoSortedArray {
    //  Merge given amount of numbers from two sorted arrays.
    //
    //Note that given amount of numbers are not larger than the length of the respective arrays.

    public int[] merge(int[] A, int m, int[] B, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(A[i] < B[j]){
                result[k++] = A[i++];
            }
            else if (A[i] > B[j]){
                result[k++] = B[j++];
            }
            else{
                result[k++] = A[i++];
                if(k < result.length){
                    result[k++] = B[j++];
                }
            }
        }

        while(i < m){
            result[k++] = A[i++];
        }
        while(j < n){
            result[k++] = B[j++];
        }

        return result;
    }
}
