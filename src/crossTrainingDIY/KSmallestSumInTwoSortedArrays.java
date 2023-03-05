package crossTrainingDIY;

import java.util.*;

public class KSmallestSumInTwoSortedArrays {
    // Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b,
    // where 'a' is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.
    public int KSmallest(int[] a, int[] b, int k){
        // assume input array cannot be null and length > 0
        if(k <= 0 || k > a.length * b.length){
            return -1;
        }

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            int tmp1 = sum(o1, a, b);
            int tmp2 = sum(o2, a, b);
            if (tmp1 == tmp2) {
                return 0;
            }
            return tmp1 < tmp2 ? -1 : 1;
        });
        Set<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(0,0));
        minHeap.offer(Arrays.asList(0, 0));
        List<Integer> cur = null;
        while(k > 0){
            cur = minHeap.poll();
            if(cur.get(0) + 1 < a.length && set.add(Arrays.asList(cur.get(0) + 1, cur.get(1)))){
                minHeap.offer(Arrays.asList(cur.get(0) + 1, cur.get(1)));
            }
            if(cur.get(1) + 1 < b.length && set.add(Arrays.asList(cur.get(0), cur.get(1) + 1))){
                minHeap.offer(Arrays.asList(cur.get(0), cur.get(1) + 1));
            }
            k--;
        }
        return a[cur.get(0)] + b[cur.get(1)];

    }

    private int sum(List<Integer> list, int[] a, int[] b){
        return a[list.get(0)] + b[list.get(1)];
    }
}
