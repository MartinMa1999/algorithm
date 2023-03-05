package crossTrainingDIY;

public class SearchInShiftedSortedArrayII {
    //There could be duplicate elements in the array
    //Return the smallest index if target has multiple occurrence
    public int search(int[] array, int target) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                right = mid;
            }
            else if(array[mid] == array[left] && array[mid] == array[right]){//这种时候没办法判断哪边有序，所以只能缩小范围，如11112111
                left++;
                right--;
            }
            else{
                if(array[mid] >= array[0]){
                    if(target >= array[0] && array[mid] > target){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                else{
                    if(target <= array[array.length - 1] && array[mid] < target){
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
            }
        }
        if(right == array.length - 1 && array[right] == target){//用来判断如果31111113，target = 3的情况
            if(array[0] == target){
                return 0;
            }
        }

        if(array[left] == target){
            return left;
        }
        if(array[right] == target){
            return right;
        }
        return -1;
    }
}
