package crossTrainingI;

public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array){
        //每次都两个两个比大小，然后小的里面找min，大的里面找max
        if(array == null || array.length == 0){
            return new int[]{-1, -1};
        }
        if(array.length == 1){
            return new int[]{array[0], array[0]};
        }
        int[] result = new int[2];
        if(array.length % 2 == 0){
            findIt(array, array.length - 1, result);
            return result;
        }
         findIt(array, array.length - 2, result);
        result[0] = Math.max(result[0], array[array.length - 1]);
        result[1] = Math.max(result[1], array[array.length - 1]);
        return result;
    }
    private void findIt(int[] array, int index, int[] result){
        int i = 0;
        int j = index;
        while(i < j){
            if(array[i] > array[j]){
                swap(array, i++, j--);
            }
        }

        int min = findMin(array, i - 1);
        int max = findMax(array, j + 1);
        result[0] = max;
        result[1] = min;
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private int findMin(int[] array, int index){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= index; i++){
            min = Math.min(min, array[i]);
        }
        return min;
    }
    private int findMax(int[] array, int index){
        int max = Integer.MIN_VALUE;
        for(int i = index; i < array.length; i++){
            max = Math.max(array[i], max);
        }
        return max;
    }
}
