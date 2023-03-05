package binarySerach;

class KClosetInSortedArray {
    public int[] kCloset(int[] array, int target, int k){
        //prefer smaller one if there is a tie
            if(array == null || k <= 0 || k > array.length){
                return new int[]{-1};
            }
            // binary search find closet two index
            int left = 0;
            int right = array.length - 1;
            while(left < right - 1){
                int mid = left + (right - left) / 2;
                if(array[mid] < target){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
            int tmp = left;
            //if target is bigger than all elements, there is no right
            if(array[right] < target){
                tmp = right;
            }
            // if target is smaller than all elements, there is no left
            else if(array[left] > target){
                tmp = -1;
            }
            left = tmp;
            right = left + 1;
            int[] result = new int[k];
            for(int i = 0; i < k; i++){
                if(left >= 0 && right < array.length){
                    if(Math.abs(array[left] - target) <= Math.abs(array[right] - target)){//每次比较左右两边大小，如果相等就选左边
                        result[i] = array[left--];//记住更新left和right！！
                    }
                    else {
                        result[i] = array[right++];
                    }
                }
                else if(left < 0){
                    result[i] = array[right++];
                }
                else{
                    result[i] = array[left--];
                }
            }
            return result;

    }
}
