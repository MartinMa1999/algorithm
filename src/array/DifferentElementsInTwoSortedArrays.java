package array;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementsInTwoSortedArrays {
    // Given two sorted arrays a and b containing only integers,
    // return two list of elements: the elements only in a but not in b, and the elements only in b but not in a.


    public int[][] diff(int[] a, int[] b) {
        int[][] result = new int[2][];
        if(a.length == 0){
            System.arraycopy(b, 0, result[1], 0, b.length);
            return result;
        }
        if(b.length == 0){
            System.arraycopy(a, 0, result[0], 0, b.length);
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                list1.add(a[i++]);
            }
            else if(a[i] == b[j]){
                i++;
                j++;
            }
            else{
                list2.add(b[j++]);
            }
        }

        while(i < a.length){
            list1.add(a[i++]);
        }
        while(j < b.length){
            list2.add(b[j++]);
        }

        result[0] = new int[list1.size()];
        result[1] = new int[list2.size()];

        for(int k = 0; k < list1.size(); k++){
            result[0][k] = list1.get(k);
        }
        for(int l = 0; l < list2.size(); l++){
            result[1][l] = list2.get(l);
        }
        return result;

    }
}
