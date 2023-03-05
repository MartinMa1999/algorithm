package crossTrainingII;

public class GetCountArray {
    //Given an array A of length N containing all positive integers from [1...N].
    // How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
    public int[] countArray(int[] array){
        if(array == null || array.length == 0){
            return new int[]{};
        }
        Element[] newArray = convert(array);
        mergeSort(newArray, 0, newArray.length - 1);
        int[] result = new int[array.length];
        for(Element e : newArray){
            result[e.index] = e.val;
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
        return merge(leftResult,rightResult);
    }
    private Element[] merge(Element[] left, Element[] right){
        Element[] result = new Element[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            if(left[i].val < right[j].val){
                left[i].num += j;
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }

        while(i < left.length){
            left[i].num += j;
            result[k++] = left[i++];
        }

        while(j < right.length){
            result[k++] = right[j++];
        }
        return result;
    }
    private Element[] convert(int[] array){
        Element[] newArray = new Element[array.length];
        for(int i = 0; i < array.length; i++){
            newArray[i] = new Element(array[i], i);
        }
        return newArray;
    }
}
class Element{
    int val;
    int index;
    int num;
    Element(int val, int index){
        this.val = val;
        this.index = index;
    }
}
