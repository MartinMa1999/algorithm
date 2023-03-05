package binarySerach;

class ClosetInSortedArray {
    public int closet(int[] array, int target){
        //array is sorted and can have duplicate elements
        if(array == null || array.length == 0){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left)/ 2;
            if(array[mid] < target){
                left = mid;
            }
            else if(array[mid] == target){
                return mid;
            }
            else{
                right = mid;
            }
        }

        return Math.abs(array[left] - target) < Math.abs(array[right] - target) ? left : right;
    }
}
