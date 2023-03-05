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
}
