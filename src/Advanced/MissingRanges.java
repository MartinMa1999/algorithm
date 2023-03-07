package Advanced;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    // Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

    public List<String> findMissingRanges(int[] num, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if(num == null || num.length == 0){
            if(lower == upper){
                result.add(lower + "");
            }
            else{
                String s = lower + "";
                s += "->";
                s += upper;
                result.add(s);
            }
            return result;
        }


        if(num[0] > lower){
            int tmp = num[0] - lower;
            if(tmp == 1){
                result.add(lower + "");
            }
            else if(tmp > 1){
                String s = lower + "";
                s += "->";
                s += num[0] - 1;
                result.add(s);
            }
        }
        for(int i = 1; i < num.length; i++){
            int tmp = num[i] - num[i - 1];
            if(tmp == 2){
                result.add(num[i] - 1 + "");
            }
            else if(tmp > 2){
                String s = num[i - 1] + 1 + "";
                s += "->";
                s += num[i] - 1;
                result.add(s);
            }
        }

        if(num[num.length - 1] < upper){
            int tmp = upper - num[num.length - 1];
            if(tmp == 1){
                result.add(upper + "");
            }
            else{
                String s = num[num.length - 1] + 1 + "";
                s += "->";
                s += upper;
                result.add(s);
            }
        }

        return result;
    }
}
