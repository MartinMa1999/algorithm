package sprintClass;

public class EqualSumPartitions {

    // An equal sum partition of a sequence of numbers is a grouping of the numbers (in the same order as the
    // original sequence) in such a way that each group has the same sum.

    // For this problem, you will write a program that takes as input a sequence of positive integers and
    // returns the smallest sum for an equal sum partition of the sequence.

    public static void main(String[] args) {
        EqualSumPartitions test = new EqualSumPartitions();
        test.getMinEqualSumPartition(20, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
    }

    public int getMinEqualSumPartition(int N, int[] X) {
        if(N == 0){
            return 0;
        }

        int sum = 0;
        for(int i = 0; i < X.length; i++){
            sum += X[i];
            if(findAll(i + 1, sum, N, X)){
                return sum;
            }
        }

        return Integer.MAX_VALUE;
    }

    private boolean findAll(int index, int value, int max, int[] array){
        if(index == max){
            return true;
        }
        int sum = 0;
        for(int i = 0; i < max - index; i++){
            sum += array[i + index];
            if(sum == value){
                return findAll(index + i + 1, value, max, array);
            }
            else if(sum > value){
                break;
            }
        }

        return false;
    }
}
