package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {
    // leetcode 502

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] helper = new int[n][2];
        for(int i = 0; i < n; i++){
            helper[i][0] = capital[i];
            helper[i][1] = profits[i];
        }
        int cur = 0;
        Arrays.sort(helper, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        for(int i = 0; i < k; i++){
            while(cur < n && helper[cur][0] <= w){
                maxHeap.offer(helper[cur][1]);
                cur++;  // bug!
            }
            if(! maxHeap.isEmpty()){
                w += maxHeap.poll();
            }
            else{
                break;
            }
        }

        return w;



    }
}
