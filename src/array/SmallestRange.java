package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    // Given k sorted integer arrays, pick k elements (one element from each of sorted arrays), what is the smallest range.
    //
    //We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

    // 相当于找一个最短区间，让所有input array都有数字在里面

    public int[] smallestRange(int[][] arrays) {
        int[] result = new int[2];
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2){
                int x1 = o1.get(0);
                int y1 = o1.get(1);
                int x2 = o2.get(0);
                int y2 = o2.get(1);

                if(arrays[x1][y1] == arrays[x2][y2]){
                    return 0;
                }

                return arrays[x1][y1] < arrays[x2][y2] ? -1 : 1;
            }
        });
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        for(int i = 0; i < arrays.length; i++){
            minHeap.offer(Arrays.asList(i, 0));
            max = Math.max(max, arrays[i][0]);
        }

        while(! minHeap.isEmpty()){
            List<Integer> tmp = minHeap.poll();
            int num = arrays[tmp.get(0)][tmp.get(1)];
            if(max - num < range){
                result[0] = num;
                result[1] = max;
                range = max - num;
            }

            if(max - num == range){
                if(num < result[0]){
                    result[0] = num;
                    result[1] = range;
                }
            }

            int[] array = arrays[tmp.get(0)];
            int y = tmp.get(1);
            if(y < array.length - 1){
                minHeap.offer(Arrays.asList(tmp.get(0), y + 1));
                max = Math.max(max, arrays[tmp.get(0)][y + 1]);
            }
            else{
                break;
            }
        }

        return result;
    }
}
