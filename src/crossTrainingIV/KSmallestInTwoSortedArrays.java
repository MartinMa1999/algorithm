package crossTrainingIV;

public class KSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k){
        int i = 0;
        int j = 0;
        while(k > 1){
            int valueA = a.length <= i + k / 2 - 1 ? Integer.MAX_VALUE : a[i + k / 2 - 1];
            int valueB = b.length <= j + k / 2 - 1 ? Integer.MAX_VALUE : b[j + k / 2 - 1];
            if(valueA < valueB){
                i += k / 2;
            }
            else{
                j += k / 2;
            }
            k -= k / 2;
        }

        if(i < a.length && j < b.length){
            return Math.min(a[i], b[j]);
        }

        return i < a.length ? a[i] : b[j];
    }
}
