package crossTrainingDIY;

public class LargestSubArrayProduct {
    // Given an unsorted array of doubles, find the sub-array that has the greatest product. Return the product.
    public double largestProduct(double[] array) {
        // 因为存在正负问题，所以必须分类讨论，要考虑前一个是正是负，有一种可能是两个都负，所以此时要前一个尽可能小，所以要有min
        double[] max = new double[array.length];
        double[] min = new double[array.length];
        max[0] = array[0];
        min[0] = array[0];
        for(int i = 1; i < array.length; i++){
            max[i] = Math.max(array[i], Math.max(max[i - 1] * array[i], min[i - 1] * array[i]));
            min[i] = Math.min(array[i], Math.min(max[i - 1] * array[i], min[i - 1] * array[i]));
        }
        double result = max[0];
        for(double e : max){
            result = Math.max(result, e);
        }
        return result;
    }

    public double betterWay(double[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        double globalMax = array[0];
        double max = array[0];
        double min = array[0];
        for(int i = 1; i < array.length; i++){
            double mx = max;
            double mn = min;
            max = Math.max(array[i], Math.max(mx * array[i], mn * array[i]));
            min = Math.min(array[i], Math.min(mx * array[i], mn * array[i]));
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }
}
