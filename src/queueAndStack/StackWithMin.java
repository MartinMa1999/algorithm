package queueAndStack;

import java.util.*;
public class StackWithMin {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<MyPair> stack2 = new ArrayDeque<>();
    int size;

    public void push(int element){
        //如果进来的元素比较小就新建一个，如果比较大就不用管他，如果相等就需要更新count的数量
        stack1.offerFirst(element);
        if(stack2.isEmpty() || element < stack2.peekFirst().value){
            stack2.offerFirst(new MyPair(element, 1));
        }
        else if(element == stack2.peekFirst().value){
            stack2.peekFirst().count++;
        }
        size++;
    }

    public Integer pop(){
        if(stack1.isEmpty()){
            return null;
        }

        int tmp = stack1.pollFirst();
        if(tmp == stack2.peekFirst().value){
            stack2.peekFirst().count--;
            if(stack2.peekFirst().count == 0){
                stack2.pollFirst();
            }
        }
        size--;
        return tmp;
    }

    public Integer top(){
        if(stack1.isEmpty()){
            return null;
        }
        return stack1.peekFirst();
    }

    public Integer min(){
        if(stack1.isEmpty()){
            return null;
        }

        return stack2.peekFirst().value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}

class MyPair{
    int value;
    int count;
    MyPair(int value, int count){
        this.value = value;
        this.count = count;
    }
}