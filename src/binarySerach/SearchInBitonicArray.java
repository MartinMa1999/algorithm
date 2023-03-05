package binarySerach;

public class SearchInBitonicArray {
    // Search for a target number in a bitonic array, return the index of the target number if found in the array, or return -1.
    //
    //A bitonic array is a combination of two sequence: the first sequence is a monotonically increasing one
    // and the second sequence is a monotonically decreasing one.

    public static void main(String[] args) {
        SearchInBitonicArray test = new SearchInBitonicArray();
        test.search(new int[]{9,5,3,2,-4,-5}, 5);
    }
    public int search(int[] array, int target) {
        if(array.length == 0){
            return -1;
        }

        if(array.length <= 2){
            for(int i = 0; i < array.length; i++){
                if(array[i] == target){
                    return i;
                }
            }
            return -1;
        }

        int index = findHeight(array);
        int left = 0;
        int right = index;
        int result = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                result = mid;
                break;
            }
            else if (array[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if(result == -1){
            left = index;
            right = array.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(array[mid] == target){
                    result = mid;
                    break;
                }
                else if (array[mid] < target){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return result;
    }

    private int findHeight(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] > array[mid - 1] && array[mid] > array[mid + 1]){
                return mid;
            }
            else if (array[mid] > array[mid - 1]){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if(array[left] < array[right]){ // 有可能是递增或者递减，因此必须讨论一下
            return right;
        }

        return 0;
    }
}
