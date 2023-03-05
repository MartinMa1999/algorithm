package DPIII;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix){
        // assume matrix cannot be null and length > 0
        int[] sum = new int[matrix[0].length];
        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j <= i; j++){
                int index = 0;
                while(index < sum.length){
                    sum[index] = prefix(matrix,i, j, index++);
                }
            }
            globalMax = Math.max(globalMax, largestArray(sum));
        }
        return globalMax;
    }
    private int prefix(int[][] matrix,int i, int j, int index){
        int sum = 0;
        while(j <= i){
            sum += matrix[j++][index];
        }
        return sum;
    }
    private int largestArray(int[] array){
        int max = array[0];
        int tmp = array[0];
        for(int i = 1; i < array.length; i++){
            if(tmp > 0){
                tmp += array[i];
            }
            else{
                tmp = array[i];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}
