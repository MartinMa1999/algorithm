package queueAndStack;

import java.util.*;

public class QueueByTwoStacks {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    int size;

    public void offer(int element){
        stack1.offerFirst(element);
        size++;
    }
    public Integer poll(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            while(! stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        size--;
        return stack2.pollFirst();
    }
    public Integer peek(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if(stack2.isEmpty()){
            while(! stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        return stack2.peekFirst();
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
}
