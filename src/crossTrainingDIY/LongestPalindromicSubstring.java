package crossTrainingDIY;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String input) {
        if(input == null || input.length() <= 1){
            return input;
        }
        int max = 1;
        String result = input.substring(0, 0);
        for(int i = 1; i < input.length() - 1; i++){// 用一个点作为起始点
            int j = 1;
            int tmp = 1;
            while(i - j >= 0 && i + j < input.length() && input.charAt(i - j) == input.charAt(i + j)){
                j++;
                tmp += 2;
            }
            if(tmp > max){
                max = tmp;
                j -= 1;
                result = input.substring(i - j, i + j + 1); // substring函数左右index前闭后开
            }
        }

        for(int i = 0; i < input.length() - 1; i++){ // 如果两个点一样的话就是两个点作为起始点
            if(input.charAt(i) == input.charAt(i + 1)){
                int j = 1;
                int tmp = 2;
                while(i - j >= 0 && i + 1 + j < input.length() && input.charAt(i - j) == input.charAt(i + 1 + j)){
                    j++;
                    tmp += 2;
                }
                if(tmp > max){
                    max = tmp;
                    j -= 1;
                    result = input.substring(i - j, i + j + 2);
                }
            }
        }
        return result;
    }

    public String betterDPWay(String input) {
        if(input == null || input.length() <= 1){
            return input;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        int[][] helper = new int[input.length()][input.length()];
        for(int j = 0; j < helper[0].length; j++){
            for(int i = j; i >= 0; i--){
                if(i == j){
                    helper[i][j] = 1;
                }
                else{
                    boolean b = input.charAt(i) == input.charAt(j);
                    if(j - i == 1){
                        if(b){
                            helper[i][j] = 2;
                        }
                    }
                    else{
                        if(helper[i + 1][j - 1] > 0 && b){
                            helper[i][j] = helper[i + 1][j - 1] + 2;
                        }
                    }
                    if(helper[i][j] > max){
                        max = helper[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return input.substring(start, end + 1);
    }
}
