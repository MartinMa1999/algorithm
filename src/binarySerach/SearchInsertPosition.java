package binarySerach;

public class SearchInsertPosition {
    // Given a sorted array and a target value, return the index where it would be if it were inserted in order.
    // If there are multiple elements with value same as target, we should insert the target before the first existing element.

    public int searchInsert(int[] input, int target) {
        if(input == null || input.length == 0){
            return 0;
        }

        int left = 0;
        int right = input.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(input[mid] < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        if(input[right] < target){
            return right + 1;
        }

        if(input[left] >= target){
            return left;
        }

        if(input[right] >= target){
            return right;
        }

        return -1;
    }
}
