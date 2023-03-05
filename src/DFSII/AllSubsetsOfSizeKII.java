package DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsOfSizeKII {
    //assume there are duplicate characters
    public List<String> allSubsets(String input, int k){
        List<String> result = new ArrayList<>();
        if(input == null){
            return result;
        }
        if(input.length() == 0){
            result.add("");
            return result;
        }

        char[] array = input.toCharArray();
        Arrays.sort(array);
        findAll(array, 0, new StringBuilder(), result, k);
        return result;
    }
    private void findAll(char[] array, int index, StringBuilder sb, List<String> result, int k){
        if(sb.length() == k){
            result.add(sb.toString());
            return;
        }

        if(index == array.length){
            return;
        }

        sb.append(array[index]);
        findAll(array, index + 1, sb, result, k);
        sb.deleteCharAt(array[index]);

        while(index < array.length - 1 && array[index] == array[index + 1]){
            index++;
        }
        findAll(array, index + 1, sb, result, k);
    }
}
