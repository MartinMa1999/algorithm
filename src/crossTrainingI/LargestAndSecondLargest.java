package crossTrainingI;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
    public int[] getIt(int[] array){
        if(array == null || array.length == 0){
            return new int[]{-1, -1};
        }
        if(array.length == 1){
            return new int[]{array[0], array[0]};
        }

        MyCell[] newArray = convert(array);
        int size = array.length;
        while(size > 1){
            compare(newArray, size);
            size = (size + 1) / 2;
        }

        return new int[]{newArray[0].val, findNext(newArray[0].compared)};
    }
    private MyCell[] convert(int[] array){
        MyCell[] newArray = new MyCell[array.length];
        for(int i = 0; i < array.length; i++){
            newArray[i] = new MyCell(array[i]);
        }
        return newArray;
    }
    private void compare(MyCell[] array, int size){
        for(int i = 0; i < size / 2; i++){
            if(array[i].val < array[size - 1 - i].val){
                swap(array, i, size - 1 - i);
            }
            array[i].compared.add(array[size - 1 - i].val);
        }
    }
    private void swap(MyCell[] array, int i, int j){
        MyCell tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private int findNext(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int num : list){
            max = Math.max(max, num);
        }
        return max;
    }
}
class MyCell{
    int val;
    List<Integer> compared;
    MyCell(int val){
        this.val = val;
        compared = new ArrayList<>();
    }
}
