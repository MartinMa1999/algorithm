package stringII;

public class ReOrderArray {
    public int[] reOrder(int[] array){
        if(array.length % 2 != 0){
            reOrder(array, 0, array.length - 2);
        }
        else{
            reOrder(array, 0, array.length - 1);
        }
        return array;
    }
    private void reOrder(int[] array, int left, int right){
        if(right - left <= 1){
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + mid / 4;
        int rightMid = left + mid * 3 / 4;

            reverse(array, leftMid, mid - 1); // bug !! 必须先reverse小的，否则当每一半都是奇数个的时候就会出bug
            reverse(array, mid, rightMid - 1);
            reverse(array, leftMid, rightMid - 1);

        reOrder(array, left, left + (leftMid - left) * 2 - 1);
        reOrder(array, left + (leftMid - left) * 2, right);
    }
    private void reverse(int[] array, int left, int right){
        while (left < right){
            int tmp = array[left];
            array[left++] = array[right];
            array[right--] = tmp;
        }
    }
}
