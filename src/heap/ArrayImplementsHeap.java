package heap;

public class ArrayImplementsHeap {
    private int[] array;
    private int size;

    ArrayImplementsHeap(){
        array = new int[10];
    }

    ArrayImplementsHeap(int length){
        array = new int[length];
    }

    ArrayImplementsHeap(int[] array){
        this.array = array;
        heapify(array);
    }

    private void heapify(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        for(int i = size / 2 - 1; i >= 0; i--){
            percolateDown(i);
        }
    }

    private void percolateDown(int i){
        while(i <= size / 2 - 1){
            int candidate = i * 2 + 1;
            candidate = candidate + 1 < size && array[candidate + 1] < array[candidate] ? candidate + 1 : candidate;

            if(array[i] > array[candidate]){
                swap(i, candidate);
                i = candidate;
            }
            else {
                break;
            }
        }
    }

    public Integer peek(){
        if(size == 0){
            return null;
        }
        return array[0];
    }

    public Integer poll(){
        if(size == 0){
            return null;
        }

        int tmp = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return tmp;
    }

    public void add(int i) throws Exception {
        if(size == array.length){
            throw new Exception();
        }

        array[size] = i;
        size++;
        percolateUp(size - 1);
    }
    private void percolateUp(int index){
        while(index > 0){
            int tmp = (index - 1) / 2;
            if(array[tmp] < array[index]){
                break;
            }
            else{
                swap(index, tmp);
                index = tmp;
            }
        }
    }

    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
