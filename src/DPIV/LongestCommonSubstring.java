package DPIV;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {
    //Find the longest common substring of two given strings.
    public String longest(String source, String target){
        // assume input string cannot be null and length > 0
        int[][] matrix = new int[source.length() + 1][target.length() + 1];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0 || source.charAt(i) != target.charAt(j)){
                    matrix[i][j] = 0;
                }
                else{
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if(max < matrix[i][j]){
                        max = matrix[i][j];
                        list.set(0, i);
                        list.set(1, j);
                    }
                }
            }
        }
        if(max == 0){
            return new String("");
        }

        int index = list.get(0) - max;
        return source.substring(index, index + max);
    }
}
