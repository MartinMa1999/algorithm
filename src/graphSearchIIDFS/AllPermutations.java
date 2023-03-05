package graphSearchIIDFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    //assume input String has no duplicate letters
    public List<String> allPermutations(String input){
        List<String> result = new ArrayList<>();
        if(input == null || input.length() == 0){
            return result;
        }
        char[] array = input.toCharArray();
        findAll(array, result, 0);
        return result;
    }
    private void findAll(char[] array, List<String> result, int index){
        if(index == array.length - 1){
            result.add(new String(array));
            return;
        }

        for(int i = index; i < array.length; i++){
            swap(array, i, index);
            findAll(array, result, index + 1);
            swap(array, i, index);
        }
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
