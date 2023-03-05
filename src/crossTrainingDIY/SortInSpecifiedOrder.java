package crossTrainingDIY;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecifiedOrder {
    //Given two integer arrays A1 and A2, sort A1 in such a way that the relative order
    // among the elements will be same as those are in A2.
    //For the elements that are not in A2, append them in the right end of the A1 in ascending order.
    // 相当于重新排序，如果是在map里面，就按照map里面排序，如果不在就比大小
    public int[] sortSpecial(int[] A1, int[] A2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A2.length; i++){
            map.put(A2[i], i);
        }
        Integer[] tmp = new Integer[A1.length];
        for(int i = 0; i < A1.length; i++){
            tmp[i] = A1[i];
        }

        Arrays.sort(tmp, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(map.containsKey(o1) && map.containsKey(o2)){
                    return map.get(o1) - map.get(o2);
                }
                else if(map.containsKey(o1)){
                    return -1;
                }
                else if(map.containsKey(o2)){
                    return 1;
                }
                else{
                    return o1 - o2;
                }
            }
        });

        int[] result = new int[A1.length];
        for(int i = 0; i < result.length; i++){
            result[i] = tmp[i];
        }
        return result;
    }
}
