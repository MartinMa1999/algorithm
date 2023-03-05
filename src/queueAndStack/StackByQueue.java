package queueAndStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackByQueue {
    Queue<Integer> queue = new ArrayDeque<>();
    int size;

    public void push(int element){
        queue.offer(element);
        size++;
    }

    public Integer pop(){
        if(queue.isEmpty()){
            return null;
        }

        for(int i = 0; i < size - 1; i++){
            queue.offer(queue.poll());
        }

        return queue.poll();
    }

    public Integer top(){
        if(queue.isEmpty()){
            return null;
        }

        for(int i = 0; i < size - 1; i++){
            queue.offer(queue.poll());
        }

        int result = queue.peek();
        queue.offer(queue.poll());
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
