package DPIV;

public class CountAscendingSubsequence {
    //Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.
    //In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.
    public int count(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        int[] helper = new int[array.length];
        helper[0] = 1;
        for(int i = 1; i < array.length; i++){
            int tmp = 0;
            for(int j = 0; j < i; j++){
                if(array[j] < array[i]){
                    tmp += helper[j];
                }
            }
            helper[i] = tmp + 1;
        }
        long sum = sum(helper);
        return sum > Integer.MAX_VALUE ? (int) sum / (int) (Math.pow(10, 9) + 7) : (int) sum;
    }
    private long sum(int[] helper){
        long sum = 0;
        for(int i : helper){
            sum += i;
        }
        return sum;
    }
}
