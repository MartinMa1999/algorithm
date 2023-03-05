package binarySerach;

class SearchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target){
        //assume that dict is sorted in ascending order
        if(dict.getIndex(0) == null || target < dict.getIndex(0)){
            return -1;
        }

        int left = 0;
        int right = 1;
        while(dict.getIndex(right) != null && dict.getIndex(right) < target){
            left = right;
            right = right * 2;
        }
        //there are two situations now: right out of bounds or target < dict.getIndex(right)

       return findIt(dict, left, right, target);
    }
    private int findIt(Dictionary dict, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(dict.getIndex(mid) == null || dict.getIndex(mid) > target){
                right = mid - 1;
            }
            else if(dict.getIndex(mid) == target){
                return mid;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}

interface Dictionary{
    public Integer getIndex(int index);
    // assume that if the index is out of bounds, return null
}