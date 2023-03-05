package DFSII;

import java.util.ArrayList;
import java.util.List;

public class CombinationsForTelephonePadI {
    public List<String> combinations(int number){
        //assume input number >= 0
        String[] pad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        String input = Integer.toString(number);
        findAll(input, pad, result, new StringBuilder(), 0);
        return result;
    }
    private void findAll(String input, String[] pad, List<String> result, StringBuilder sb, int index){
        if(index == input.length()){
            result.add(sb.toString());
            return;
        }

        int num = input.charAt(index) - '0';
        String s = pad[num];
        if(s.length() == 0){
            findAll(input, pad, result, sb, index + 1);
        }
        else{
            for(int i = 0; i < s.length(); i++){
                findAll(input, pad, result, sb.append(s.charAt(i)), index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
