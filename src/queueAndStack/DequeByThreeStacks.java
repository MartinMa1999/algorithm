package queueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    Deque<Integer> stack3 = new ArrayDeque<>();
    int size;

    public void pushFirst(int element){
        stack1.offerFirst(element);
        size++;
    }

    public void pushLast(int element){
        stack2.offerFirst(element);
        size++;
    }

    public Integer popFirst(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if(stack1.isEmpty()){
            int tmpSize = stack2.size() / 2;
            for(int i = 0; i < tmpSize; i++){
                stack3.offerFirst(stack2.pollFirst());
            }

            while(! stack2.isEmpty()){
                stack1.offerFirst(stack2.pollFirst());
            }
            while(! stack3.isEmpty()){
                stack2.offerFirst(stack3.pollFirst());
            }
//            Deque<Integer> tmp = stack1;
//            stack1 = stack2;
//            stack2 = tmp;如果直接换的话就会导致此时的stack1里面element的顺序恰好是反的。
        }
        size--;
        return stack1.pollFirst();
    }

    public Integer popLast(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        if(stack2.isEmpty()){
            int tmpSize = stack1.size() / 2;
            for(int i = 0; i < tmpSize; i++){
                stack3.offerFirst(stack1.pollFirst());
            }

            while(! stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
            while(! stack3.isEmpty()){
                stack1.offerFirst(stack3.pollFirst());
            }
        }

        size--;
        return stack2.pollFirst();
    }

    public Integer topFirst(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if(stack1.isEmpty()) {
            int tmpSize = stack2.size() / 2;
            for (int i = 0; i < tmpSize; i++) {
                stack3.offerFirst(stack2.pollFirst());
            }

            while (!stack2.isEmpty()) {
                stack1.offerFirst(stack2.pollFirst());
            }
            while (!stack3.isEmpty()) {
                stack2.offerFirst(stack3.pollFirst());
            }

        }
        return stack1.peekFirst();
    }

    public Integer topLast(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        if(stack2.isEmpty()){
            int tmpSize = stack1.size() / 2;
            for(int i = 0; i < tmpSize; i++){
                stack3.offerFirst(stack1.pollFirst());
            }

            while(! stack1.isEmpty()){
                stack2.offerFirst(stack1.pollFirst());
            }
            while(! stack3.isEmpty()){
                stack1.offerFirst(stack3.pollFirst());
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
