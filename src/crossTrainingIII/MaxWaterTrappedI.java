package crossTrainingIII;

public class MaxWaterTrappedI {
    //Given a non-negative integer array representing the heights of a list of adjacent bars.
    //Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

    public int max(int[] array){
        //木桶原理，谁小移谁，总考虑当前的左右挡板max里面的min
        if(array == null || array.length == 0){
            return -1;
        }
        int sum = 0;

        int i = 0;
        int j = array.length - 1;
        int leftMax = array[i];
        int rightMax = array[j];
        while(i <= j){
            leftMax = Math.max(array[i], leftMax);
            rightMax = Math.max(array[j], rightMax);
            if(array[i] < array[j]){
                sum += Math.min(leftMax, rightMax) - array[i];
                i++;
            }
            else{
                sum += Math.min(leftMax, rightMax) - array[j];
                j--;
            }
        }

        return sum;
    }
    //TC = O(n), SC = O(1)

    public int method2(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < array.length; i++){
            leftMax = Math.max(array[i], leftMax);
            left[i] = leftMax;
        }
        for(int i = array.length - 1; i >= 0; i--){
            rightMax = Math.max(array[i], rightMax);
            right[i] = rightMax;
        }

        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += Math.min(left[i], right[i]) - array[i];
        }
        return sum;
    }
}
