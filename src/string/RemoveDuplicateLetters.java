package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicateLetters {
    // Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
    // You must make sure your result is the smallest in lexicographical order among all possible results.

    // 大概思路就是每次见到一个新的就观察一下前面的字母是不是字典序再它后面，如果是的话就看一下后面还有没有这个字母，如果有就把他弹出去；见到已经见过的肯定说明
    // 不需要操作了，所以直接标记就可以
    public static void main(String[] args) {
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        test.removeDuplicateLetters(new String("jeaaeqenbgpjpztzuwwzukc"));
    }
    public String removeDuplicateLetters(String input) {
        if(input == null || input.length() == 0){
            return input;
        }

        boolean[] visited = new boolean[26];
        int[] num = new int[26];
        for(int i = 0; i < input.length(); i++){
            num[input.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(! visited[tmp - 'a']){
                while(sb.length() > 0 && sb.charAt(sb.length() - 1) - tmp > 0){
                    if(num[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false; // bug!!不能先删除
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    else{
                        break;
                    }
                }
                visited[tmp - 'a'] = true;
                sb.append(tmp);
            }
            num[tmp - 'a'] -= 1;
        }

        return sb.toString();

    }
}
