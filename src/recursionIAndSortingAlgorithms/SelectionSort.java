package recursionIAndSortingAlgorithms;

class SelectionSort {
    public int[] selectionSort(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }

        for(int i = 0; i < array.length - 1; i++){
            int globalMin = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[globalMin] < array[j]){
                    globalMin = j;
                }
            }
            int tmp = array[i];
            array[i] = array[globalMin];
            array[globalMin] = tmp;
        }
        return array;
    }
}
