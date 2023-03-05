package DPI;

public class ArrayHopperI {
    //Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
    //A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
    //Determine if you are able to reach the last index.(jump game)
    public boolean canJump(int[] array){
        boolean[] result = new boolean[array.length];
        result[array.length - 1] = true;

        for(int i = array.length - 2; i >= 0;  i--){
            if(array[i] != 0){
                int tmp = array[i];
                while(tmp > 0) {
                    if (tmp + i < array.length && result[tmp + i]) {
                        result[i] = true;
                        break;
                    }
                    tmp--;
                }
            }
        }
        return result[0];

    }
}
