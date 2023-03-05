package heap;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort test = new HeapSort();
        test.heapsort(new int[]{4,4,1,1});
    }
    public int[] heapsort(int[] array) {
        if(array == null || array.length <= 1){
            return array;
        }

        for(int i = array.length - 1; i > 0; i--){
            heapify(array, i);
            swap(array, 0, i);
        }
        return array;
    }
    private void heapify(int[] array, int index){
        for(int i = (index - 1) / 2; i >= 0; i--){
            percolateDown(array, i, index);
        }
    }
    private void percolateDown(int[] array, int i, int index){
        while(i * 2 + 1 <= index){ // bug!!!这里应该判断的是子节点有没有超界，而不是自己有没有超界
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int candidate = left;
            if(right <= index && array[right] > array[left]){ // bug!!比较的是左右的array值
                candidate = right;
            }

            if(array[i] >= array[candidate]){
                break;
            }
            else{
                swap(array, i, candidate);
                i = candidate;
            }
        }
    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
