package crossTrainingDIY;

public class LargestSubMatrixProduct {
    // Given a matrix that contains doubles, find the sub-matrix with the largest product.
    // Return the product of the sub-matrix.
    // 先压缩成1D array，再算乘积最大的子集
    public static void main(String[] args) {
        double[][] matrix = new double[][]{{1,-0.2,3,2},{-4,1,-1,1},{-3,2,2,2},{-1,1,1,1}};
        LargestSubMatrixProduct test = new LargestSubMatrixProduct();
        test.largest(matrix);
    }
    public double largest(double[][] matrix) {
        double[] helper = new double[matrix[0].length];
        double largest = matrix[0][0];
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j >= 0; j--){
                for(int k = 0; k < matrix[0].length; k++){
                    helper[k] = times(matrix, i, j, k);
                }
                double subLarge = findIt(helper);
                largest = Math.max(largest, subLarge);
            }
        }
        return largest;
    }
    private double times(double[][] matrix, int i, int j, int k){
        double result = 1;
        for(int m = j; m <= i; m++){
            result *= matrix[m][k];
        }
        return result;
    }
    private double findIt(double[] array){
        double max = array[0];
        double min = array[0];
        double result = array[0];
        for(int i = 1; i < array.length; i++){
            double mx = max;
            double mn = min;
            max = Math.max(array[i], Math.max(mx * array[i], mn * array[i]));
            min = Math.min(array[i], Math.min(mx * array[i], mn * array[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}
