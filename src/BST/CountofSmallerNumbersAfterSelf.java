package BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    // You are given an integer array nums, and you have to return a new counts array.
    // The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

    //想法和get count array很像，但是需要处理重复值
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Element[] array = convert(nums);
        array = mergeSort(array, 0, array.length - 1);
        Integer[] tmp = reSort(array);
        return Arrays.asList(tmp);
    }
    private Element[] convert(int[] array){
        Element[] result = new Element[array.length];
        for(int i = 0 ; i < array.length; i++){
            result[i] = new Element(array[i], i, 0);
        }
        return result;
    }

    private Element[] mergeSort(Element[] array, int left, int right){
        if(left == right){
            return new Element[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        Element[] leftResult = mergeSort(array, left, mid);
        Element[] rightResult = mergeSort(array, mid + 1, right);

        return merge(leftResult, rightResult);
    }
    private Element[] merge(Element[] left, Element[] right){
        int i = 0;
        int j = 0;
        int k = 0;
        Element[] result = new Element[left.length + right.length];
        while(i < left.length && j < right.length){
            if(left[i].val <= right[j].val){ // bug! 当存在重复值的时候必须要挪左边的，因为要保证左边的那个元素对应的已经改了count，如果不改，当j变大就会出问题
                left[i].count += j;
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }
        while(i < left.length){
            left[i].count += j;
            result[k++] = left[i++];
        }
        while(j < right.length){
            result[k++] = right[j++];
        }
        return result;
    }
    private Integer[] reSort(Element[] array){
        Integer[] result = new Integer[array.length];
        for(Element e : array){
            result[e.index] = e.count;
        }
        return result;
    }
}
class Element{
    int val;
    int index;
    int count;
    Element(int val, int index, int count){
        this.val = val;
        this.index = index;
        this.count = count;
    }
}
