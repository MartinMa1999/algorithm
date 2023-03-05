package graphSearchAlgorithmsIII;

import java.util.*;

public class SevenPuzzle {
    //Find the minimum number of steps from the given state to the final state.
    public int findMin(int[] values){
        //assume input array cannot be null and length == 8;
        Queue<MyArray> queue = new ArrayDeque<>();
        queue.offer(new MyArray(values));
        Map<MyArray, Integer> map = new HashMap<>();
        map.put(new MyArray(values), 0);
        MyArray target = new MyArray(new int[] {0,1,2,3,4,5,6,7});

        if(target.equals(new MyArray(values))){
            return 0;
        }
        while(! queue.isEmpty()){
            MyArray tmp = queue.poll();
            int[] array = tmp.array();
            int index = 0;// index of 0
            for(int i = 0; i < array.length; i++){
                if(array[i] == 0){
                    index = i;
                    break;
                }
            }

            for(int i = index - 1; i <= index + 1; i += 2){
                if(validLeft(array, i, index, map)){
                    MyArray newArray = new MyArray(swap(array, i, index));
                    if(newArray.equals(target)){
                        return map.get(tmp) + 1;
                    }
                    queue.offer(newArray);
                    map.put(newArray, map.get(tmp) + 1);
                }
            }
            for(int i = index - 4; i <= index + 4; i += 8){
                if(valid(array, i, index, map)){
                    MyArray newArray = new MyArray(swap(array, i, index));
                    if(newArray.equals(target)){
                        return map.get(tmp) + 1;
                    }
                    queue.offer(newArray);
                    map.put(newArray, map.get(tmp) + 1);
                }
            }
        }
        return -1;
    }
    private int[] swap(int[] array, int i, int j){
        int[] result = Arrays.copyOf(array, array.length);
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return result;
    }
    private boolean validLeft(int[] array, int i, int index, Map<MyArray, Integer> map){
        if((i == 3 && index == 4) || (i == 4 && index == 3)){
            return false;
        }

        if(i < 0 || i >= array.length){
            return false;
        }

        return !map.containsKey(new MyArray(swap(array, i, index)));
    }
    private boolean valid(int[] array, int i, int index, Map<MyArray, Integer> map){
        if(i < 0 || i >= array.length){
            return false;
        }

        return !map.containsKey(new MyArray(swap(array, i, index)));
    }
}

record MyArray(int[] array) {

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyArray)) {
            return false;
        }
        MyArray tmp = (MyArray) o;
        if (tmp.array().length != 8) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != tmp.array()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int sum = 0;
        for(int i : array){
            sum = sum * 10 + i;
        }
        return sum;
    }

}
