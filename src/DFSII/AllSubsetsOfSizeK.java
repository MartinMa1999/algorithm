package DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsOfSizeK {
    public List<String> allSubsets(String s, int k){
        //assume k > 0 && k <= s.length(), no duplicate nums
        List<String> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        if(s.length() == 0){
            result.add("");
            return result;
        }

        char[] array = s.toCharArray();
        Arrays.sort(array);

        findAll(array, result, 0, k, new StringBuilder());
        return result;
    }

    private void findAll(char[] array, List<String> result, int index, int k, StringBuilder sb){
        if(sb.length() == k){
            result.add(sb.toString());
            return;
        }

        if(index == array.length){
            return;
        }

        sb.append(array[index]);
        findAll(array, result, index + 1, k, sb);
        sb.deleteCharAt(sb.length() - 1);

        findAll(array, result, index + 1, k, sb);
    }
}
