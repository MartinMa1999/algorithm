package crossTrainingDIY;

public class TotalOccurrence {
    //Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.
    public int totalOccurrence(int[] array, int target) {
        if(array == null || array.length == 0){
            return 0;
        }

        if(target < array[0] || target > array[array.length - 1]){
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        int index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid + 1;
            }
            else if(array[mid] == target){
                index = mid;
                break;
            }
            else{
                right = mid - 1;
            }
        }
        if(index == -1){
            return 0;
        }
        int count = 1;
        for(int i = 1; index - i >= 0 && index + i < array.length; i++){
            if(array[index - i] != target && array[index + i] != target){
                break;
            }
            if(array[index - i] == target){
                count++;
            }
            if(array[index + i] == target){
                count++;
            }
        }
        return count;


    }
}
