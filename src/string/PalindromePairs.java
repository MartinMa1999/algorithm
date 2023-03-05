package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    // Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
    // so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if(words == null || words.length == 0){
            return result;
        }

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i == j){
                    continue;
                }
                if(valid(words, i, j)){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean valid(String[] words, int i, int j){
        String a = words[i];
        String b = words[j];
        String s = a + b;
        int x = 0;
        int y = s.length() - 1;
        while(x < y){
            if(s.charAt(x) != s.charAt(y)){
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}
