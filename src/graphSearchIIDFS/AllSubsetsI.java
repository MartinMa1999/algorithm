package graphSearchIIDFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    public List<String> findAll(String set){
        List<String> result = new ArrayList<>();
        if(set == null || set.length() == 0){
            result.add("");
            return result;
        }

        findAll(set, result, 0, new StringBuilder());
        return result;
    }
    private void findAll(String set, List<String> result, int index, StringBuilder sb){
        if(index == set.length()){
            result.add(sb.toString());
            return;
        }

        // choose the character at index
        sb.append(set.charAt(index));
        findAll(set, result, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        // do not choose
        findAll(set, result, index + 1, sb);

    }

    // TC = O(n ^ 2), SC = O(height)
}
