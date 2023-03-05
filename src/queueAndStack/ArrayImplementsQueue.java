package queueAndStack;

import java.util.Arrays;

public class ArrayImplementsQueue {
    private int[] array;
    private int size;
    private int head;
    private int tail;

    ArrayImplementsQueue(){
        array = new int[10];
        head = 0;
        tail = 1;
    }

    ArrayImplementsQueue(int length){
        array = new int[length];
        head = 0;
        tail = 1;
    }

    public void offer(int ele){
        tail = (tail + 1) % array.length == 0 ? 0 : tail + 1;
        array[tail++] = ele;
        size++;
        if(tail == size){
            int[] newArray = new int[array.length * 3 / 2];
            int tmp = size - 1;
            int k = 1;
            while(tmp > 0){
                head = head + 1 == array.length ? 0 : head + 1;
                newArray[k++] = array[head];
                tmp--;
            }
            head = 0;
            tail = k;
            array = newArray;
        }
    }

    public Integer poll(){
        if(size == 0) {
            return null;
        }
        head = (head + 1) % array.length == 0 ? 0 : head + 1;
        size--;
        return array[head];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
