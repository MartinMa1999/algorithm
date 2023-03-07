package string;

public class LongestValidParentheses {
    // Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    //valid的标志就是左右括号数量相等。但是如果只遍历从左到右，当左括号比右括号多的时候就会出问题，因此为了避免这种情况，再从右到左遍历一次
    //也可以用stack始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标
    public int longestValidParentheses(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }

        int length = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < input.length(); i++){
            char tmp = input.charAt(i);
            if(tmp == '('){
                left++;
            }
            else{
                right++;
                if(right > left){
                    left = 0;
                    right = 0;
                }
            }

            if(left == right){
                length = Math.max(length, right * 2);
            }
        }

        left = 0;
        right = 0;
        for(int i = input.length() - 1; i>= 0; i--){
            char tmp = input.charAt(i);
            if(tmp == '('){
                left++;
            }
            else{
                right++;
            }
            if(left == right){
                length = Math.max(length, left + right);
            }
            else if(left > right){
                left = 0;
                right = 0;
            }
        }

        return length;
    }
}
