package array;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    // Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.size() && j < B.size()){
            if(A.get(i) < B.get(j)){
                i++;
            }
            else if(A.get(i).equals(B.get(j))){ // 注意integer一旦超过intern pool，就会出bug
                result.add(A.get(i));
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return result;
    }
}
