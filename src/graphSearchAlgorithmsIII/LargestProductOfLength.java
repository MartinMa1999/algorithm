package graphSearchAlgorithmsIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestProductOfLength {
    //Given a dictionary containing many words, find the largest product of two words’ lengths,
    //such that the two words do not share any common characters.
    public int largest(String[] dict){
        if(dict == null || dict.length == 0){
            return -1;
        }

        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return 0;
                }
                return o1.length() < o2.length() ? -1 : 1;
            }
        });

        PriorityQueue<myPair> maxHeap = new PriorityQueue<myPair>(new Comparator<myPair>() {
            @Override
            public int compare(myPair o1, myPair o2) {
                int x = o1.x;
                int y = o1.y;
                int z = o2.x;
                int w = o2.y;
                int length1 = dict[x].length() * dict[y].length();
                int length2 = dict[z].length() * dict[w].length();

                if(length1 == length2){
                    return 0;
                }

                return length1 < length2 ? 1 : -1;
            }
        });

        maxHeap.offer(new myPair(0, 1));
        while(! maxHeap.isEmpty()){
            myPair tmp = maxHeap.poll();
            if(valid(tmp, dict)){
                return dict[tmp.x].length() * dict[tmp.y].length();
            }
            else{
                if(tmp.y < dict.length - 1){
                    myPair newElement = new myPair(tmp.x, tmp.y + 1);
                    maxHeap.offer(newElement);
                }

                if(tmp.y - tmp.x > 1){
                    myPair newElement = new myPair(tmp.x + 1, tmp.y);
                    maxHeap.offer(newElement);
                }
            }
        }
        return 0;
    }
    private boolean valid(myPair tmp, String[] dict){
        int x = tmp.x;
        int y = tmp.y;
        int num1 = 0;
        int num2 = 0;
        for(int i = 0; i < dict[x].length(); i++){
            num1 |= 1 << (dict[x].charAt(i) - 'a'); // suppose all lower case
        }
        for(int j = 0; j < dict[y].length(); j++){
            num2 |= 1 << (dict[y].charAt(j) - 'a');
        }

        return (num1 & num2) == 0;

    }
}
class myPair{
    int x;
    int y;
    myPair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
