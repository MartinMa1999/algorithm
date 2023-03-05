package graphSearchAlgorithmsIII;

import java.util.*;

public class KthClosetPointTo000 {
    public List<Integer> kCloset(int[] a, int[] b, int[] c, int k){
        //assume k > 0 && k < a.length * b.length * c.length
        //assume arrays are sorted in ascending order
        Set<List<Integer>> set = new HashSet<>();
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long tmp1 = sum(o1, a, b, c);
                long tmp2 = sum(o2, a, b, c);
                if(tmp1 == tmp2){
                    return 0;
                }
                return tmp1 < tmp2 ? -1 : 1;
            }
        });
        minHeap.offer(Arrays.asList(0,0,0));
        int count = 1;
        while(count < k){
            List<Integer> tmp = minHeap.poll();
            if(tmp.get(0) + 1 < a.length && set.add(Arrays.asList(tmp.get(0) + 1, tmp.get(1), tmp.get(2)))){
                minHeap.offer(Arrays.asList(tmp.get(0) + 1, tmp.get(1), tmp.get(2)));
            }
            if(tmp.get(1) + 1 < b.length && set.add(Arrays.asList(tmp.get(0), tmp.get(1) + 1, tmp.get(2)))){
                minHeap.offer(Arrays.asList(tmp.get(0), tmp.get(1) + 1, tmp.get(2)));
            }
            if(tmp.get(2) + 1 < c.length && set.add(Arrays.asList(tmp.get(0), tmp.get(1), tmp.get(2) + 1))){
                minHeap.offer(Arrays.asList(tmp.get(0), tmp.get(1), tmp.get(2) + 1));
            }
            count++;
        }
        List<Integer> result = new ArrayList<>();
        result.add(a[minHeap.peek().get(0)]);
        result.add(b[minHeap.peek().get(1)]);
        result.add(c[minHeap.peek().get(2)]);
        return result;



    }
    private long sum(List<Integer> list, int[] a, int[] b, int[] c){
        long sum = 0;
        sum += (long) a[list.get(0)] * a[list.get(0)];
        sum += (long) b[list.get(1)] * b[list.get(1)];
        sum += (long) c[list.get(2)] * c[list.get(2)];

        return sum;
    }
}
