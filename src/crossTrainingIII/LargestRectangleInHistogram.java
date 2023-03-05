package crossTrainingIII;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largest(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }

        Deque<MyPair> stack = new ArrayDeque<>();
        stack.offerFirst(new MyPair(0, array[0]));
        int largest = 0;
        int i = 1;
        while (i < array.length){
            if(array[i] < array[i - 1]){
                while(! stack.isEmpty() && stack.peekFirst().val < array[i]){
                    MyPair tmp = stack.pollFirst();
                    int num = 0;
                    num = (stack.isEmpty() ? i : i - stack.peekFirst().index - 1) * tmp.val; // 还得考虑后进来的往左也可以走,所以必须用stack。peekFirst()的index判断
                    largest = Math.max(largest, num);
                }
            }
            stack.offerFirst(new MyPair(i, array[i]));
            i++;
        }
        while (! stack.isEmpty()){
            MyPair tmp = stack.pollFirst();
            int size = 0;
            if(! stack.isEmpty()){
                size = tmp.val * (i - stack.peekFirst().index - 1);
            }
            else{
                size = tmp.val * i;
            }
            largest = Math.max(largest, size);
        }
        return largest;
    }

    public int betterWay(int[] array){
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);
        int i = 1;
        while(i < array.length){
            if(array[i] < array[i - 1]){
                while(! stack.isEmpty() && array[i] < array[stack.peekFirst()]){
                    int tmp = stack.pollFirst();
                    int size = 0;
                    if(! stack.isEmpty()){
                        size = array[tmp] * (i - stack.peekFirst() - 1);
                    }
                    else{
                        size = array[tmp] * i;
                    }
                    max = Math.max(max, size);
                }
            }
            stack.offerFirst(i);
            i++;
        }

        while(! stack.isEmpty()){
            int tmp = stack.pollFirst();
            int size = 0;
            if(! stack.isEmpty()){
                size = array[tmp] * (i - stack.peekFirst() - 1);
            }
            else{
                size = array[tmp] * i;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}
class MyPair{
    int index;
    int val;

    MyPair(int index, int val){
        this.index = index;
        this.val = val;
    }
}
