package DFSII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParenthesesII {
    public List<String> allValid(int l, int m, int n){
        char[] array = new char[]{'(', ')', '<', '>', '{', '}'};
        int[] nums = new int[]{l, l, m, m, n, n};
        List<String> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        findAll(array, nums, result, 0, 2 * (l + m + n), new StringBuilder(), stack);
        return result;
    }
    private void findAll(char[] array, int[] nums, List<String> result, int index, int sum, StringBuilder sb, Deque<Integer> stack){
        if(index == sum){
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i < array.length; i++){
            if(i % 2 == 0){
                if(nums[i] > 0){
                    sb.append(array[i]);
                    stack.offerFirst(i);
                    nums[i]--;
                    findAll(array, nums, result, index + 1, sum, sb, stack);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    nums[i]++;
                }
            }
            else{
                if(nums[i] > 0 && ! stack.isEmpty() && stack.peekFirst() == i - 1){
                    sb.append(array[i]);
                    stack.pollFirst();
                    nums[i]--;
                    findAll(array, nums, result, index + 1, sum ,sb, stack);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i - 1);
                    nums[i]++;
                }
            }
        }
    }
}
