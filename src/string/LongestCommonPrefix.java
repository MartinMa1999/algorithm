package string;

public class LongestCommonPrefix {
    // Write a function to find the longest common prefix string amongst an array of strings

    // 题目要求从第一个字母开始找，所以不需要DFS
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        String tmp = "";
        int minLength = Integer.MAX_VALUE;
        for(String s : strs){
            if(s.length() < minLength){
                minLength = s.length();
                tmp = s;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minLength; i++){
            char c = tmp.charAt(i);
            for(String s : strs){
                if(s.charAt(i) != c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();

    }
}
