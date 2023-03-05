package graphSearchAlgorithmsIII;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthSmallestWithOnly357AsFactors {
    public int smallest(int k){
        if(k <= 0){
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        set.add(3 * 5 * 7);
        minHeap.offer(3 * 5 * 7);
        int count = 1;
        while (count < k){
            int tmp = minHeap.poll();
            if(set.add(tmp * 3)){
                minHeap.offer(tmp * 3);
            }
            if(set.add(tmp * 5)){
                minHeap.offer(tmp * 5);
            }
            if(set.add(tmp * 7)){
                minHeap.offer(tmp * 7);
            }
            count++;
        }

        return minHeap.peek();
    }
}
