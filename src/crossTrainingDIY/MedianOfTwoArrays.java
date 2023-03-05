package crossTrainingDIY;

import java.util.Arrays;

public class MedianOfTwoArrays {
    // Given two arrays of integers, find the median value.
    // 必须先排序，才能用binary search
    public double median(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int length = a.length + b.length;
        if(length % 2 == 1){
            int mid = length / 2;
            return findIt(a, b, mid + 1);
        }
        else{
            int mid1 = length / 2;
            int mid2 = length / 2 + 1; // 因为下面的方法是找到第k小的，所以实际上比如是6个，就是第三小的和第四小的，所以是 + 1
            return (findIt(a, b, mid1) + findIt(a, b, mid2)) / 2.0;
        }
    }
    private double findIt(int[] a, int[] b, int k){
        int i = 0;
        int j = 0;
        while(k > 1){
            int valueA = i + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[i + k / 2 - 1];
            int valueB = j + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[j + k / 2 - 1];
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
