package leetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        restoreIPAddress.restoreIpAddresses("101023");
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        StringBuilder sb = new StringBuilder();
        findAll(s, sb, 0, 0, result);
        return result;
    }

    private void findAll(String s, StringBuilder sb, int index, int num, List<String> result){
        if(num == 3){
            if(index == s.length() || index < s.length() - 3){
                return;
            }

            if(valid(s, index)){
                String tmp = s.substring(index);
                sb.append(tmp);
                result.add(sb.toString());
                sb.delete(sb.length() - tmp.length(), sb.length());
            }

            return;
        }
        int tmp = 0;
        for(int i = 0; i < 3 && index + i < s.length(); i++){
            if(valid2(s, index, i)){
                tmp++;
                sb.append(s.charAt(index + i));
                sb.append('.');
                findAll(s, sb, index + i + 1, num + 1, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        for(; tmp > 0; tmp--){
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean valid(String s, int index){
        if(index == s.length() - 1){
            return true;
        }

        if(s.charAt(index) == '0'){
            return false;
        }

        if(index == s.length() - 3){
            if(s.charAt(index) > '2'){
                return false;
            }

            if(s.charAt(index) == '2' && s.charAt(index + 1) > '5'){
                return false;
            }

            if(s.charAt(index) == '2' && s.charAt(index + 1) == '5' && s.charAt(index + 2) > '5'){
                return false;
            }
        }

        return true;
    }

    private boolean valid2(String s, int index, int i){
        if(i == 0){
            return true;
        }

        if(s.charAt(index) == '0'){
            return false;
        }

        if(i == 2){
            if(s.charAt(index) > '2'){
                return false;
            }

            if(s.charAt(index) == '2' && s.charAt(index + 1) > '5'){
                return false;
            }

            if(s.charAt(index) == '2' && s.charAt(index + 1) == '5' && s.charAt(index + 2) > '5'){
                return false;
            }
        }

        return true;
    }
}
