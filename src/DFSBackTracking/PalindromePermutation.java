package DFSBackTracking;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    // Given a string, determine if a permutation of the string could form a palindrome.

    // swap-swap,只不过要看最后的结果是否满足要求
    public boolean canPermutePalindrome(String input) {
        if(input == null || input.length() == 0){
            return true;
        }
        char[] array = input.toCharArray();
        return findAll(array, 0);
    }
    private boolean findAll(char[] array, int index){
        if(index == array.length){
            return isPalindrome(array);
        }

        Set<Character> set = new HashSet<>();
        for(int i = index; i < array.length; i++){
            if(set.add(array[i])){
                swap(array, i, index);
                if(findAll(array, index + 1)){
                    return true;
                }
                swap(array, i, index);
            }
        }
        return false;
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
