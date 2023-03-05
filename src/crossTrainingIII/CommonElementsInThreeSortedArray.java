package crossTrainingIII;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c){
        //assume no array is null and all length > 0
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length && k < c.length){
            if(a[i] < b[j] && a[i] < c[k]){
                i++;
            }
            else if(b[j] < a[i] && b[j] < c[k]){
                j++;
            }
            else if(c[k] < a[i] && c[k] < b[j]){
                k++;
            }
            else if(a[i] < b[j] && a[i] == c[k]){
                i++;
                k++;
            }
            else if(b[j] < a[i] && b[j] == c[k]){
                j++;
                k++;
            }
            else if(a[i] < c[k] && b[j] < c[k]){
                i++;
                j++;
            }
            else{
                result.add(a[i]);
                i++;
                j++;
                k++;
            }
        }
        return result;
    }
}
