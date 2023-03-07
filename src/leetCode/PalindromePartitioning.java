package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    //Given a string s, partition s such that every
    //substring
    // of the partition is a
    //palindrome
    //. Return all possible palindrome partitioning of s.

    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        int n = s.length();
        boolean[][] helper = new boolean[n][n];

        for(int j = 1; j < n; j++){
            for(int i = j; i >= 0; i--){
                if(i == n - 1){
                    continue;
                }

                helper[i][j] = s.charAt(i) == s.charAt(j) && helper[i + 1][j - 1];
            }
        }
        List<String> list = new ArrayList<>();
        findAll(s, helper, 0, list, result);
        return result;
    }

    private void findAll(String s, boolean[][] helper, int index, List<String> list ,List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(helper[index][i]){
                list.add(s.substring(index, i + 1));
                findAll(s, helper, i + 1, list ,result);
                list.remove(list.size() - 1);
            }
        }
    }
}
