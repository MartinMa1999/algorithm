package hashTableAndStringI;

import java.util.HashSet;
import java.util.Set;

public class MissingNumberI {
    public int missing(int[] array){
        int i = 0;
        int j = 0;
        for(int num : array){
            i ^= num;
        }

        for(int k = 1; k <= array.length + 1; k++){
            j ^= k;
        }

        return i ^ j;
    }

    public int method2(int[] array){
        Set<Integer> set = new HashSet<>();
        for(int num : array){
            set.add(num);
        }
        int tmp = 0;
        for(int i = 1; i <= array.length + 1; i++){
            if(! set.contains(i)){
                tmp = i;
                break;
            }
        }
        return tmp;

    }
}
