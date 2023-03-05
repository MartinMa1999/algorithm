package DPIV;

public class CuttingWoodI {
    // There is a wooden stick with length L >= 1, we need to cut it into pieces,
    // where the cutting positions are defined in an int array A.
    // The positions are guaranteed to be in ascending order in the range of [1, L - 1].
    // The cost of each cut is the length of the stick segment being cut.
    // Determine the minimum total cost to cut the stick into the defined pieces.
    public int minCost(int[] cuts, int length){
        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        for(int i = 0; i < cuts.length; i++){
            helper[i + 1] = cuts[i];
        }
        helper[helper.length - 1] = length;

        int[][] matrix = new int[helper.length][helper.length];
        for(int i = 1; i < matrix.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(j == i - 1){
                    matrix[j][i] = 0;
                }
                else{
                    matrix[j][i] = Integer.MAX_VALUE;
                    for(int k = j + 1; k < i; k++){
                        matrix[j][i] = Math.min(matrix[j][i], matrix[j][k] + matrix[k][i]);//遍历所有可能的中间切点，然后找min cost
                    }
                    matrix[j][i] += helper[i] - helper[j];
                }
            }
        }
        return matrix[0][matrix.length - 1];
    }
}
