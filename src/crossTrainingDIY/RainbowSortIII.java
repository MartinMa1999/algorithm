package crossTrainingDIY;

public class RainbowSortIII {
    // Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.
    public int[] rainbowSortIII(int[] array, int k) { // count sort, TC = O(n)
        if(array.length == 0){
            return array;
        }
        int[] count = new int[k + 1];
        for(int i : array){
            count[i]++;
        }
        int i = 0;
        int j = 1;
        while(i < array.length){
            if(count[j] == 0){
                while(j < count.length && count[j] == 0){
                    j++;
                }
            }
            array[i++] = j;
            count[j]--;
        }
        return array;
    }

    public int[] mergeSortWay(int[] array, int k) { // TC = O(n log k)
        if (array == null || array.length == 0) {
            return array;
        }
        if (k <= 0) {
            return array;
        }

        int len = array.length;
        int startColor = 1;
        int left = 0, right = len - 1;

        sortKColors(array, left, right, startColor, k);
        return array;
    }

    private void sortKColors(int[] array, int left, int right,
                             int startColor, int endColor) {
        if (left >= right) {
            return;
        }
        if (startColor >= endColor) {
            return;
        }

        int l = left, r = right;
        int midColor = startColor + (endColor - startColor) / 2;

        while (l <= r) {
            while (l <= r && array[l] <= midColor) {
                l++;
            }
            while (l <= r && array[r] > midColor) {
                r--;
            }
            if (l <= r) {
                swap(array, l++, r--);
            }
        }

        sortKColors(array, left, r, startColor, midColor);
        sortKColors(array, l, right, midColor + 1, endColor);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
