package DFSII;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfSubsets {
    public List<String> allPermutations(String input){
        // assume no duplicate characters
        List<String> result = new ArrayList<>();
        if(input == null){
            return result;
        }
        if(input.length() == 0){
            result.add("");
            return result;
        }
        char[] array = input.toCharArray();
        findAll(array, result, 0);
        result.add("");
        return result;
    }
    private void findAll(char[] array, List<String> result, int index){
        for(int i = index; i < array.length; i++){
            swap(array, i, index);
            findAll(array, result, index + 1);
            result.add(new String(array, 0, index + 1));
            swap(array, i, index);
        }
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
