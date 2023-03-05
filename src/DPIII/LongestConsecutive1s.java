package DPIII;

public class LongestConsecutive1s {
    public int longest(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int globalMax = 0;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                sum = 0;
            }
            else{
                sum += array[i];
                globalMax = Math.max(globalMax, sum);
            }
        }
        return globalMax;
    }
}
