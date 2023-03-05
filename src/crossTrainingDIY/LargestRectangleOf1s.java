package crossTrainingDIY;

import crossTrainingIII.LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleOf1s {
    // Determine the largest rectangle of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the area.
    // 与加强联系III中 the largest rectangle in histogram 方法类似
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,0,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
        LargestRectangleOf1s test = new LargestRectangleOf1s();
        test.largest(matrix);
    }

    public int largest(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] helper = new int[matrix[0].length];
        int globalMax = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0){
                    helper[j] = matrix[i][j];
                }
                else{
                    if(matrix[i][j] == 0){
                        helper[j] = 0;
                    }
                    else{
                        helper[j] += 1;
                    }
                }
            }
            globalMax = Math.max(globalMax, findIt(helper));// 每次都把高度为i的matrix压扁成一行，然后看能形成多长的矩形
        }
        return globalMax;
    }
    private int findIt(int[] array){
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);
        int i = 1;
        while(i < array.length){
            if(array[i] < array[i - 1]){
                while(! stack.isEmpty() && array[i] < array[stack.peekFirst()]){
                    int tmp = stack.pollFirst();
                    int size = 0;
                    if(! stack.isEmpty()){
                        size = array[tmp] * (i - stack.peekFirst() - 1);
                    }
                    else{
                        size = array[tmp] * i;
                    }
                    max = Math.max(max, size);
                }
            }
            stack.offerFirst(i);
            i++;
        }

        while(! stack.isEmpty()){
            int tmp = stack.pollFirst();
            int size = 0;
            if(! stack.isEmpty()){
                size = array[tmp] * (i - stack.peekFirst() - 1);
            }
            else{
                size = array[tmp] * i;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
