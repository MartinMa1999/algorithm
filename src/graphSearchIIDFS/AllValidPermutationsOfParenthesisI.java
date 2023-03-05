package graphSearchIIDFS;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParenthesisI {
    public List<String> allValid(int n){
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }

        findAll(result, n, 0, 0, new StringBuilder());
        return result;
    }
    private void findAll(List<String> result, int n, int left, int right, StringBuilder sb){
        if(left == n && right == n){
            result.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append('(');
            findAll(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left){
            sb.append(')');
            findAll(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // TC = O(2 ^ n), SC = O(height)
}
