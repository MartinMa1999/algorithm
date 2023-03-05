package crossTrainingDIY;

public class SearchInShiftedSortedArrayI {
    //Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
    //For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
    public static void main(String[] args) {
        SearchInShiftedSortedArrayI test = new SearchInShiftedSortedArrayI();
        System.out.println(test.search(new int[]{2,1}, 1));
    }
    public int search(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] >= array[0]){//每次通过和左右比大小来判断左右是否有序。如果不加等号，在mid = 0的时候就会出bug
                if(array[mid] > target && target >= array[0]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(array[mid] < target && target <= array[array.length - 1]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
