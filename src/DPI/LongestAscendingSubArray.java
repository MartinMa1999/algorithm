package DPI;

public class LongestAscendingSubArray {
    public int longest(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int globalMax = 1;
        int tmp = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > array[i - 1]){
                tmp++;
                globalMax = Math.max(tmp, globalMax);
            }
            else{
                tmp = 1;
            }
        }
        return globalMax;
    }
}
