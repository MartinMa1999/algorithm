package DPTopic;

import java.util.Arrays;

public class LeastMovesToAscendingArray {

    //Given an integer array, what is the minimum number of operations to convert it to an ascending array.
    //
    //One operation you can move one element of the array to another position.

    // 本质上相当于先找到longest ascending subsequence, 然后把那些剩下位置不对的数字插进去而已
    public int leastMoves(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int longest = findIt(array);
        return array.length - longest;
    }
    private int findIt(int[] array){
        int[] helper = new int[array.length + 1];
        helper[1] = array[0];
        int len = 1;
        for(int i = 1; i < array.length; i++){
            if(array[i] > helper[len]){
                helper[++len] = array[i];
            }
            else{
                int index = Arrays.binarySearch(helper, 1, len, array[i]);
                if(index < 0){
                    index = - index - 1;
                    helper[index] = array[i];
                }
            }
        }
        return len;
    }
}
