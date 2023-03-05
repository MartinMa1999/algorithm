package hashTableAndStringI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    //String[] is not sorted
    public String[] topKFrequent(String[] input, int k){
        if(input == null || input.length == 0 || k <= 0 || k >= input.length){
            return null;
        }
        String[] result = new String[k];
        Map<String, Integer> map = new HashMap<>();
        for(String s : input){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<MyPair> maxHeap = new PriorityQueue<MyPair>(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
               if(o1.key == o2.key){
                return 0;
               }
               return o1.key < o2.key ? 1 : -1;
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String s = entry.getKey();
            int key = entry.getValue();
            MyPair myPair = new MyPair(s, key);
            maxHeap.offer(myPair);
        }

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll().s;
        }

        return result;
    }
}
class MyPair{
    String s;
    int key;
    MyPair(String s, int key){
        this.s = s;
        this.key = key;
    }
}
