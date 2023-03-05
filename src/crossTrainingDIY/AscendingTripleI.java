package crossTrainingDIY;

import java.util.Arrays;

public class AscendingTripleI {
    // Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].
    public static void main(String[] args) {
        int[] array = new int[]{1,5,0,4,1,3};
        AscendingTripleI test = new AscendingTripleI();
        test.existIJK(array);
    }
    public boolean existIJK(int[] array) { // longest ascending subsequence
        if(array == null || array.length <= 2){
            return false;
        }
        int[] helper = new int[4];
        int len = 1;
        helper[1] = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > helper[len]){
                helper[++len] = array[i];
                if(len == 3){
                    return true;
                }
            }
            else{
                int index = Arrays.binarySearch(helper, 1, len, array[i]); // bug! 这里必须是1，否则如果array里面有0，换位置的时候会出错
                if(index < 0){
                    index = - index - 1;
                    helper[index] = array[i];
                }
            }
        }
        return false;
    }

    public boolean greedyWay(int[] array){
        if(array == null || array.length <= 2){
            return false;
        }
        // 虽然叫greedy，但是和上面的方法基本相同，只不过只维护两个数字，每次都改比array[i]大一个的数字即可
        int first = array[0];
        int second = Integer.MAX_VALUE;
        for(int i = 1; i < array.length; i++){
            if(array[i] > second){
                return true;
            }
            else if(array[i] <= first){ // bug! 必须有等号，否则first和second可能一样了
                first = array[i];
            }
            else{
                second = array[i];
            }
        }
        return false;
    }
}
