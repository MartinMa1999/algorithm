package heapAndGraphSearch_BFS;

import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k){
        if(k <= 0 || k > array.length){
            return new int[]{};
        }
        int[] result = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : array){
            minHeap.offer(num);
        }
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }

        return result;
    }
}
