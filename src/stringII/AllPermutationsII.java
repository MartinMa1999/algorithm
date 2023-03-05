package stringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    //Given a string with possible duplicate characters, return a list with all permutations of the characters

    public List<String> allPermutations(String input){
        List<String> result = new ArrayList<>();
        if(input == null || input.length() == 0){
            result.add(input);
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

        Set<Character> set = new HashSet<>();
        for(int i = index; i < array.length; i++){
            if(! set.contains(array[i])){
                swap(array, index, i);
                findAll(array, result, index + 1);
                swap(array, index, i);

                set.add(array[i]);
            }
        }
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
