package finalExam;

import java.util.ArrayList;
import java.util.List;

public class FindAllDecodeWays {
    // 1 -> A ... 26 -> Z
    public List<String> findAll(String s){
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        findAll(s, result, new StringBuilder(), 0);
        return result;
    }

    private void findAll(String s, List<String> result, StringBuilder sb, int index){
        if(index == s.length()){
            result.add(sb.toString());
            return;
        }
        int sum = 0;
        for(int i = 0; i < 2 && index + i < s.length(); i++){
            sum = sum * 10 + s.charAt(index) - '0';
            if(sum == 0){
                break;
            }
            if(sum <= 26){
                sb.append((char) (sum - 1 + 'A'));
                findAll(s, result, sb, index + i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private void offical(List<String> result, StringBuilder sb, String input, int index){
        if(index == input.length()){
            result.add(sb.toString());
            return;
        }

        int number = input.charAt(index) - '0';
        if(number > 0 && number <= 9){
            sb.append((char) (number - 1 + 'A'));
            offical(result,sb, input,index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(index + 1 < input.length()){
            number = number * 10 + input.charAt(index + 1) - '0';
            if(number >= 10 && number <= 26){
                sb.append((char) (number - 1 +'A'));
                offical(result, sb, input, index + 2);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // TC = 2 ^ n * n, SC = O(height)
}
