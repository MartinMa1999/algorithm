package recursionIAndSortingAlgorithms;

class MergeSort {
    public int[] mergeSort(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }

        return mergeSort(array, 0, array.length - 1);
    }
    private int[] mergeSort(int[] array, int left, int right){
        if(left == right){
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }
    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }

        while(i < left.length){
            result[k++] = left[i++];
        }
        while(j < right.length){
            result[k++] = right[j++];
        }

        return result;
    }

    public int[] helperWay(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }

        int[] helper = new int[array.length];

        helper(array, helper, 0, array.length - 1);
        return array;
    }
    private void helper(int[] array, int[] helper, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left ,mid);
        mergeSort(array, mid + 1, right);
        merge(array, helper, left, mid, right);
    }
    private void merge(int[] array, int[] helper, int left, int mid, int right){
        int i = left;
        // copy values to helper array
        while(i <= right){
            helper[i] = array[i++];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        int j = left;
        while(leftIndex <= mid && rightIndex <= right){
            if(helper[leftIndex] < helper[rightIndex]){
                array[j++] = helper[leftIndex++];
            }
            else{
                array[j++] = helper[rightIndex++];
            }
        }
        while(leftIndex < mid){
            array[j++] = helper[leftIndex++];
        }
        while(rightIndex < right){
            array[j++] = helper[rightIndex++];
        }
    }
}
