package DFSBackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePermutationII {
    // Given a string s, return all the palindromic permutations (without duplicates) of it.
    // Return an empty list if no palindromic permutation could be form.

    public List<String> generatePalindromes(String input) {
        List<String> result = new ArrayList<>();
        if(input == null || input.length() == 0){
            return result;
        }
        char[] array = input.toCharArray();

        findAll(array, 0, result);
        return result;
    }
    private void findAll(char[] array, int index, List<String> result){
        if(index == array.length){
            if(isPalindrome(array)){
                result.add(String.valueOf(array));
            }
            return;
        }

        Set<Character> set = new HashSet<>();
        for(int i = index; i < array.length; i++){
            if(set.add(array[i])){
                swap(array, i, index);
                findAll(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }
    private void swap(char[] array, int i, int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private boolean isPalindrome(char[] array){
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(array[i] != array[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
