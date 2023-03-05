package heap;

public class DetermineIfArrayIsMinHeap {
    // Determine if the given integer array is min heap.

    public boolean isMinHeap(int[] array) {
        if(array == null || array.length <= 1){
            return true;
        }
        int fast = 0;
        int slow = 1;
        while(slow < array.length){
            if(array[slow] < array[fast]){
                return false;
            }
            if(slow + 1 < array.length && array[slow + 1] < array[fast]){
                return false;
            }
            fast++;
            slow += 2;
        }
        return true;
    }
}
