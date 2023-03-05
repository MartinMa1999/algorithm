package recursionIAndSortingAlgorithms;

class Move0SToTheEndI {
    public int[] moveZero(int[] array){
        if(array == null || array.length == 0){
            return array;
        }
        int i = 0;
        int j = array.length - 1;
        while(i <= j){
            if(array[i] == 0){
                swap(array, i, j);
                j--;
            }
            else{
                i++;
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
