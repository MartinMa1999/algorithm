package DPTopic;

public class LeastInsertionsToFormAPalindrome {
    // Insert the least number of characters to a string in order to make the new string a palindrome.
    // Return the least number of characters should be inserted.

    // 先找最长的palindrome sequence,可以理解成后续把palindrome拆开，然后在缝里放那些单独的元素，所以直接做差即可
    public int leastInsertion(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }

        int[][] helper = new int[input.length()][input.length()];
        for(int j = 0; j < helper.length; j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    helper[i][j] = 1;
                }
                else{
                    if(input.charAt(j) == input.charAt(i)){
                        helper[i][j] = helper[i + 1][j - 1] + 2;
                    }
                    else{
                        helper[i][j] = Math.max(helper[i + 1][j], helper[i][j - 1]);
                    }
                }
            }
        }
        return input.length() - helper[0][helper.length - 1];
    }

    // 每次都往两边看，想自己的上一个状态是什么。凡是上一个状态有可能两头都变的，一定是二维dp
    public int methodTwo(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        int[][] helper = new int[input.length()][input.length()];
        for(int j = 0; j < helper.length; j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    helper[i][j] = 0;
                }
                else{
                    if(input.charAt(j) == input.charAt(i)){
                        helper[i][j] = Math.min(Math.min(helper[i + 1][j] + 1, helper[i][j - 1] + 1), helper[i + 1][j - 1]);
                    }
                    else{
                        helper[i][j] = Math.min(helper[i + 1][j] + 1, helper[i][j - 1] + 1);
                    }
                }
            }
        }
        return helper[0][helper.length - 1];
    }
}
