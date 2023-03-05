package crossTrainingDIY;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    //["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    //逆波兰表达式
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        int num1;
        int num2;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens){
            switch (s) {
                case "+" -> {
                    num2 = stack.pollFirst();
                    num1 = stack.pollFirst();
                    stack.offerFirst(num1 + num2);
                }
                case "-" -> {
                    num2 = stack.pollFirst();
                    num1 = stack.pollFirst();
                    stack.offerFirst(num1 - num2);
                }
                case "*" -> {
                    num2 = stack.pollFirst();
                    num1 = stack.pollFirst();
                    stack.offerFirst(num1 * num2);
                }
                case "/" -> {
                    num2 = stack.pollFirst();
                    num1 = stack.pollFirst();
                    stack.offerFirst(num1 / num2);
                }
                default -> stack.offerFirst(Integer.valueOf(s));
            }
        }
        return stack.peekFirst();
    }
    public int betterWay(String[] tokens){
        int[] result = new int[tokens.length / 2 + 1];
        int index = 0;
        for(String s : tokens){
            switch (s){
                case "+" ->{
                    result[index - 2] += result[--index];
                    break;
                }
                case "-" ->{
                    result[index - 2] -= result[--index];
                    break;
                }
                case "*" ->{
                    result[index - 2] *= result[--index];
                    break;
                }
                case "/" ->{
                    result[index - 2] /= result[--index];
                }
                default -> {
                    result[index++] = Integer.parseInt(s);
                }
            }
        }
        return result[0];
    }
}
