package heap;

import java.util.PriorityQueue;

public class KSortedArray {
    // Given an unsorted integer array, each element is at most k step from its position after the array is sorted.
    //
    //Can you sort this array with time complexity better than O(nlogn)?

    //因为每个数字最多能左右移动k位，所以直接放2k到minheap里面，然后每次一定能找到最小的数，每一轮加数字进去即可
    public int[] ksort(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if(array == null || array.length == 0 || k == 0){
            return array;
        }
        int[] result = new int[array.length];
        for(int i = 0; i < k * 2 && i < array.length; i++){
            minHeap.offer(array[i]);
        }
        int j = 0;
        for(int i = k * 2; i < array.length; i++){
            result[j++] = minHeap.poll();
            minHeap.offer(array[i]);
        }

        while(! minHeap.isEmpty()){
            result[j++] = minHeap.poll();
        }
        return result;
    }
}
