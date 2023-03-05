package queueAndStack;

import java.util.*;

public class SortWith2Stacks {
    // there are totally 2 stacks and after sorting numbers must be in ascending order from top to bottom
    public void sort(Deque<Integer> stack){
        if(stack == null || stack.size() == 0){
            return;
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        sort(stack, stack2);
    }
    private void sort(Deque<Integer> input, Deque<Integer> stack){
        while(! input.isEmpty()){
            int globalMin = Integer.MAX_VALUE;
            while(! input.isEmpty()){
                int tmp = input.pollFirst();
                globalMin = Math.min(tmp, globalMin);
                stack.offerFirst(tmp);
            }
            int count = 0;
            while(! stack.isEmpty()){
                int tmp = stack.pollFirst();
                if(tmp > globalMin){
                    input.offerFirst(tmp);
                }
                else{
                    count++;
                }
            }
            while(count > 0){
                stack.offerFirst(globalMin);
                count--;
            }
        }

        while(! stack.isEmpty()){
            input.offerFirst(stack.pollFirst());
        }
    }
}
