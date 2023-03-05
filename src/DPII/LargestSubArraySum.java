package DPII;

public class LargestSubArraySum {
    //另起炉灶
    public int largest(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int sum = array[0];
        int globalMax = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum > 0){
                sum += array[i];
            }
            else{
                sum = array[i];
            }
            globalMax = Math.max(globalMax, globalMax + array[i]);
        }
        return globalMax;

    }
}
