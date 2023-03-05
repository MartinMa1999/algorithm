package binarySerach;

class LastOccurrence {
    public int lastOccurrence(int[] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid + 1;
            }
            else if(array[mid] == target){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        if(array[right] == target){
            return right;
        }
        if(array[left] == target){
            return left;
        }

        return -1;
    }

}
