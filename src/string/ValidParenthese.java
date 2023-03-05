package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthese {
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid. The brackets must close in the correct order.

    public boolean isValid(String input) {
        if(input == null || input.length() == 0){
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < input.length()){
            if(input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '['){
                stack.offerFirst(input.charAt(i));
            }
            else{
                if(stack.isEmpty()){ // bug !! 有可能全是右括号
                    return false;
                }
                if(input.charAt(i) == ')'){
                    if(stack.peekFirst() != '('){
                        return false;
                    }
                    stack.pollFirst();
                }
                else if(input.charAt(i) == '}'){
                    if(stack.peekFirst() != '{'){
                        return false;
                    }
                    stack.pollFirst();
                }
                else{
                    if(stack.peekFirst() != '['){
                        return false;
                    }
                    stack.pollFirst();
                }
            }
            i++;
        }

        return stack.isEmpty(); // bug!有可能全是左括号
    }
}
