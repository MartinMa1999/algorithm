package DPTopic;

public class RegularExpressionMatching {
    // Implement regular expression matching with support for '.' and '*'. '.' Matches any single character.
    // '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).


    // 考虑如果遇到*表示连续的k个前一个char，就有两种情况，一种是0个，则把它和前一个char直接扔了；另一种是需要匹配，但是此时要求i和j - 1的char
    // 相等，就只需要看一下上一个，即[i - 1][j]是否成立。因为*可以表示无数个，所以后面的index必须是j，否则就不一定成立
    public boolean isMatch(String input, String pattern) {
        if(input == null && pattern == null){
            return true;
        }
        if(input == null || pattern == null){
            return false;
        }

        boolean[][] helper = new boolean[input.length() + 1][pattern.length() + 1];

        helper[0][0] = true;
        for(int i = 0; i < helper.length; i++){
            for(int j = 1; j < helper[0].length; j++){
                if(pattern.charAt(j - 1) == '*'){
                    helper[i][j] = helper[i][j - 2];
                    if(valid(input, pattern, i, j - 1)){
                        helper[i][j] = helper[i][j] || helper[i - 1][j];
                    }
                }
                else{
                    if(valid(input, pattern, i, j)){
                        helper[i][j] = helper[i - 1][j - 1];
                    }
                }
            }
        }
        return helper[helper.length - 1][helper[0].length - 1];
    }

    private boolean valid(String input, String pattern, int i, int j){
        if(i == 0){
            return false;
        }
        if(pattern.charAt(j - 1) == '.'){
            return true;
        }
        return input.charAt(i - 1) == pattern.charAt(j - 1);
    }
}
