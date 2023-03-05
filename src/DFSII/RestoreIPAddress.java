package DFSII;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args) {
        String input = new String("11819111");
        RestoreIPAddress test = new RestoreIPAddress();
        test.restore(input);
    }
    public List<String> restore(String input){
        List<String> result = new ArrayList<>();
        if(input == null || input.length() < 4 || input.length() > 12){
            return result;
        }
        findAll(input, result, new StringBuilder(), 0, 0);
        return result;
    }
    private void findAll(String input, List<String> result, StringBuilder sb, int offset, int level){
        if(level == 4){
            if(sb.length() == input.length() + 4){
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
                sb.append('.');
            }
            return;
        }

        int count = 0;
        for(int i = 0; i < 3; i++){
            if(valid(input, offset, i + 1)){
                count++;
                sb.append(input.charAt(i + offset));
                sb.append('.');
                findAll(input, result ,sb, offset + i + 1, level + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        while(count > 0){
            sb.deleteCharAt(sb.length() - 1);
            count--;
        }
    }
    private boolean valid(String input, int offset, int num){
        if(offset + num - 1 >= input.length()){//必须要先判断超界，再判断别的
            return false;
        }

        if(num == 1){
            return true;
        }

        if(input.charAt(offset) - '0' == 0){
            return false;
        }

        int sum = 0;
        while(num > 0){
            sum = sum * 10 + input.charAt(offset) - '0';
            offset++;
            num--;
        }
        return sum <= 255;
    }
}
