package leetCode;

public class KthMissingPositiveNumber {
    // leetcode 1539

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,11,14,29,31,40,44};
        KthMissingPositiveNumber kthMissingPositiveNumber = new KthMissingPositiveNumber();
        kthMissingPositiveNumber.findKthPositive(arr, 20);
    }
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int num = arr[mid];
            int count = num - mid - 1;
            if(count < k){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left + k;

    }
}
