package crossTrainingDIY;

public class LargestSubArraySum {
    // Given an unsorted integer array, find the sub-array that has the greatest sum.
    // Return the sum and the indices of the left and right boundaries of the sub-array.
    // If there are multiple solutions, return the leftmost sub-array.
    public int[] largestSum(int[] array) {
        if(array == null || array.length == 0){
            return new int[]{-1, -1, -1};
        }

        int[] result = new int[]{array[0], 0, 0};
        int max = array[0];
        int tmp = array[0];
        for(int i = 1; i < array.length; i++){
            if(tmp > 0){
                if(tmp + array[i] > max){
                    max = tmp + array[i];
                    result[0] = max;
                    result[2] = i;
                }
                tmp += array[i];
            }
            else{
                tmp = array[i];
                if(array[i] > max){
                    max = array[i];
                    result[0] = max;
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
        return result;
    }
}
