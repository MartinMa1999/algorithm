package crossTrainingIII;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInKSortedLists {
    //There could be duplicate elements in each of the lists
    public List<Integer> common(List<List<Integer>> input){
        List<Integer> result = input.get(0);
        for(int i = 1; i < input.size(); i++){
            result = helper(result, input.get(i));
        }
        return result;
    }
    private List<Integer> helper(List<Integer> list1, List<Integer> list2){
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                i++;
            }
            else if(list1.get(i) > list2.get(j)){
                j++;
            }
            else{
                result.add(list1.get(i));
                i++;
                j++;
            }
        }
        return result;

    }
}
