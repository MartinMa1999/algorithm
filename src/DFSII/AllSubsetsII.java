package DFSII;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsII {
    public List<String> allSubsets(String input){
        //assume input is sorted in ascending order
        List<String> result = new ArrayList<>();
        if(input == null){
            return result;
        }
        if(input.length() == 0){
            result.add("");
            return result;
        }

        findAll(input, result, 0, new StringBuilder());
        return result;
    }
    private void findAll(String input, List<String> result, int index, StringBuilder sb){
        if(index == input.length()){
            result.add(sb.toString());
            return;
        }

        sb.append(input.charAt(index));
        findAll(input, result, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        while(index < input.length() - 1 && input.charAt(index) == input.charAt(index + 1)){
            index++;
        }

        findAll(input, result, index + 1, sb);
    }
}
