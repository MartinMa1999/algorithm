package binarySerach;

public class FindLocalMinimum {
    // Given an unsorted integer array, return the local minimum's index.
    //
    //An element at index i is defined as local minimum when it is smaller than all its possible two neighbors a[i - 1] and a[i + 1]
    //
    //(you can think a[-1] = +infinite, and a[a.length] = +infinite)

    // There are no duplicate elements in the array.
    //There is always one and only one result for each case.

    public int localMinimum(int[] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;

            if(array[mid] < array[mid + 1]){// 显然如果只有一个答案，那么整个数组肯定某种意义上是单调的。如果mid比下一个小，那么mid的左边一定存在答案，如果是存在多个答案，那么右边就不一定存在答案
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

}
