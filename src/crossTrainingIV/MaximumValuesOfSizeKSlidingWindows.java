package crossTrainingIV;

import java.util.*;

public class MaximumValuesOfSizeKSlidingWindows {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,1,1};
        MaximumValuesOfSizeKSlidingWindows test = new MaximumValuesOfSizeKSlidingWindows();
        test.max(array, 2);
    }
    public List<Integer> max(int[] array, int k){// lazy delete
        // assume array cannot be null and length >= k
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        int i = 1;
        deque.offerFirst(0);
        while(i < k){
            if(array[i] > array[deque.peekFirst()]){
                while(! deque.isEmpty() && array[i] > array[deque.peekFirst()]){
                    deque.pollFirst();
                }
            }
            deque.offerFirst(i);
            i++;
        }

        result.add(array[deque.peekLast()]);

        for( ; i < array.length; i++){
            if(array[i] > array[deque.peekFirst()]){
                while(! deque.isEmpty() && array[i] > array[deque.peekFirst()]){
                    deque.pollFirst();
                }
            }
            deque.offerFirst(i);
            if(deque.peekLast() == i - k){
                deque.pollLast();
            }
            result.add(array[deque.peekLast()]);
        }
        return  result;
    }

    public List<Integer> betterWay(int[] array, int k){//maxHeap
        if(array == null || k <= 0){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int tmp1 = o1.get(1);
                int tmp2 = o2.get(1);
                if(tmp1 == tmp2){
                    return 0;
                }

                return tmp1 < tmp2 ? 1 : -1;
            }
        });

        int i = 0;
        while(i < k - 1){
            List<Integer> tmp = Arrays.asList(i, array[i]);
            maxHeap.offer(tmp);
            i++;
        }
        for( ; i < array.length; i++){
            maxHeap.offer(Arrays.asList(i, array[i]));
            if(maxHeap.peek().get(0) <= i - k){ //因为你是一直存着，所以要踢掉所有的范围之外的东西
                while (! maxHeap.isEmpty() && maxHeap.peek().get(0) <= i - k){
                    maxHeap.poll();
                }
            }
            result.add(maxHeap.peek().get(1));
        }
        return result;
    }
}
