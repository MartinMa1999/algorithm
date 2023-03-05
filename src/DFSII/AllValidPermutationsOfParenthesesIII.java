package DFSII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParenthesesIII {
    //subject to the priority restriction: {} higher than <> higher than ()
    public List<String> allValid(int l, int m, int n){
        List<String> result = new ArrayList<>();
        char[] array = new char[]{'(', ')', '<', '>', '{', '}'};
        int[] nums = new int[]{l, l, m, m, n, n};
        Deque<Integer> stack = new ArrayDeque<>();
        findAll(array, nums, new StringBuilder(), result, stack, 2 * (l + m + n));
        return result;
    }
    private void findAll(char[] array, int[] nums, StringBuilder sb, List<String> result, Deque<Integer> stack, int sum){
        if(sb.length() == sum){
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i < array.length; i++){
            if(i % 2 == 0){
                if(nums[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)){
                    sb.append(array[i]);
                    nums[i]--;
                    stack.offerFirst(i);
                    findAll(array, nums, sb, result, stack, sum);
                    sb.deleteCharAt(sb.length() - 1);
                    nums[i]++;
                    stack.pollFirst();
                }
            }
            else{
                if(nums[i] > 0 && ! stack.isEmpty() && stack.peekFirst() == i - 1){
                    sb.append(array[i]);
                    nums[i]--;
                    stack.pollFirst();
                    findAll(array, nums, sb, result, stack, sum);
                    sb.deleteCharAt(sb.length() - 1);
                    nums[i]++;
                    stack.offerFirst(i - 1);
                }
            }
        }
    }
}
