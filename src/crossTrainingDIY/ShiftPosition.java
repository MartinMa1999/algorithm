package crossTrainingDIY;

public class ShiftPosition {
    //Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions,
    // For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.
    public int shiftPosition(int[] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            if(array[left] < array[right]){
                return left;
            }
            int mid = left + (right - left) / 2;
            if(array[mid] >= array[left]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
