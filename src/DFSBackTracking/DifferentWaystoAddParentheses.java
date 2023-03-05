package DFSBackTracking;

import java.util.*;

public class DifferentWaystoAddParentheses {
    //Given a string of numbers and operators, return all possible results from computing all the different possible ways
    // to group numbers and operators in Ascending order. The valid operators are +, - and *.

    // 相当于先走到最底下，然后得到左右不同的可能结果，再组合返回。类似于all BST
    public static void main(String[] args) {
        DifferentWaystoAddParentheses test = new DifferentWaystoAddParentheses();
        test.diffWaysToCompute(new String("2*3*2-1*2-2*3-1"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(input == null || input.length() == 0){
            return result;
        }
        result = findAll(0, input.length() - 1, input);
        Collections.sort(result);
        return result;
    }
    private List<Integer> findAll(int left, int right, String input){
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){ // bug!!必须是&&
                continue;
            }
            else{
                List<Integer> leftResult = findAll(left, i - 1, input);
                List<Integer> rightResult = findAll(i + 1, right, input);
                for(int k : leftResult){
                    for(int j : rightResult){
                        int cur = 0;
                        if(input.charAt(i) == '+'){
                            cur = k + j;
                        }
                        else if(input.charAt(i) == '-'){
                            cur = k - j;
                        }
                        else if(input.charAt(i) == '*'){
                            cur = k * j;
                        }
                        result.add(cur);
                    }
                }
            }
        }
        if(result.isEmpty()){
            int cur = 0;
            for(int i = left; i <= right; i++){
                cur = cur * 10 + (input.charAt(i) - '0');
            }
            result.add(cur);
        }
        return result;
    }
}
