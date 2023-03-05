package crossTrainingDIY;

public class RainbowSortII {
    public static void main(String[] args) {
        RainbowSortII test = new RainbowSortII();
        test.rainbowSortII(new int[]{2,0,3,0,1,0});
    }

    public int[] rainbowSortII(int[] array) {
        if(array.length == 0){
            return array;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = array.length - 1;

        while(k <= l){
            if(array[k] == 0){
                swap(array, i, k);
                if(i != j) { // bug! 如果i = j，此时两次换完等于没换，所以必须要考虑i != j的时候，此时i指向1，j指向2，必须两个都换才行
                    swap(array, j, k);
                }
                i++;
                j++;
                k++;
            }
            else if(array[k] == 1){
                swap(array, j, k);
                j++;
                k++;
            }
            else if(array[k] == 2){
                k++;
            }
            else{
                swap(array, k, l);
                l--;
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
