package DPTopic;

public class WildcardMatching {
    // Given two strings where first string is a normal string and second string may contain wild card characters.
    // Write a function that returns true if the two strings match. The following are allowed wildcard characters in first string.
    //* --> Matches with 0 or more instances of any character or set of characters.
    //? --> Matches with any one character.

    // dp[i][j]表示以ij为结尾的string是否match。必须用 + 1的matrix，否则处理不了长度为0的情况；遇到？或者char相同就看两边都缩短一个的上一步；
    // 遇到*就有两种可能， 如果用就看i - 1 到 j，如果不用就看 i 到 j - 1。因为是dp，所以i - 1 到 j实际上包含了所有可能的input到 pattern里面的
    // j的位置所存在的match可能。只要较小的i存在match，则较大的一定能match
    public boolean match(String input, String pattern) {
        if(input == null && pattern == null){
            return true;
        }
        if(input == null || pattern == null){
            return true;
        }

        boolean[][] helper = new boolean[input.length() + 1][pattern.length() + 1];
        helper[0][0] = true;
        for(int i = 1; i < helper[0].length; i++){
            if(pattern.charAt(i - 1) == '*'){
                helper[0][i] = true;
            }
            else{
                break;
            }
        }

        for(int i = 1; i < helper.length; i++){
            for(int j = 1; j < helper[0].length; j++){
                if(pattern.charAt(j - 1) == '*'){
                    helper[i][j] = helper[i - 1][j] || helper[i][j - 1];
                }
                else if(input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?'){
                    helper[i][j] = helper[i - 1][j - 1];
                }
            }
        }

        return helper[helper.length - 1][helper[0].length - 1];
    }
}
