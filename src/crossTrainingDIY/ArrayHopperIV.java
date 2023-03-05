package crossTrainingDIY;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ArrayHopperIV {
    // Given an array A of non-negative integers, you are initially positioned at an arbitrary index of the array.
    // A[i] means the maximum jump distance from that position (you can either jump left or jump right).
    // Determine the minimum jumps you need to reach the right end of the array.
    // Return -1 if you can not reach the right end of the array.
    public static void main(String[] args) {
        ArrayHopperIV test1 = new ArrayHopperIV();
        test1.minJump(new int[]{4,2,1,2,0,0}, 0);
    }

    public int minJump(int[] array, int index) {
        if(index == array.length - 1){ // {0}
            return 0;
        }
        if(array[index] == 0){
            return -1;
        }
        if(array.length == 1){ // {1}
            return 0;
        }
        if(index + array[index] >= array.length - 1){ // {1,2,3   1}
            return 1;
        }
        int count = 1;
        int result = 0;
        Set<Integer> set = new HashSet<>(); // 存index
        Queue<Integer> queue = new ArrayDeque<>(); // 存index
        queue.offer(index);
        set.add(index);
        breakpoint:
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                index = queue.poll();
                int tmp = index - array[index];
                for(int i = tmp; i < index; i++){
                    if(i >= 0 && set.add(i)){
                        queue.offer(i);
                    }
                }
                tmp = index + array[index];
                if(tmp >= array.length - 1){
                    result = count;
                    break breakpoint;
                }
                else{
                    for(int i = 1; i <= array[index]; i++){
                        if(set.add(index + i)){
                            queue.offer(index + i);
                        }
                    }

                }
                size--;
            }
            count++;
        }
        if(result == 0){
            return -1;
        }
        return result;

    }
}
