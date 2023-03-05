package crossTrainingDIY;

import java.util.LinkedList;

public class SortWithThreeStacks {
    // merge sort，每次都把s1和s2里面与s1长度相近的元素排好序，然后放到s1里，以此类推来做mergesort
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        if(s1 == null || s1.size() <= 1){
            return;
        }

        sort(s1, s2, s3, s1.size());
    }
    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length){
        if(length == 1){
            return;
        }
        int half = length / 2;
        for(int i = 0; i < half; i++){
            s2.offerFirst(s1.pollFirst());
        }

        sort(s1, s2, s3, length - half);
        sort(s2, s1, s3, half);

        merge(s1, s2, s3, length - half, half);

        transfer(s3, s1, length);
    }
    private void merge(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length1, int length2){
        int i = 0;
        int j = 0;
        while(i < length1 && j < length2){
            if(s1.peekFirst() < s2.peekFirst()){
                s3.offerFirst(s1.pollFirst());
                i++;
            }
            else{
                s3.offerFirst(s2.pollFirst());
                j++;
            }
        }
        while(i < length1){
            s3.offerFirst(s1.pollFirst());
            i++;
        }
        while(j < length2){
            s3.offerFirst(s2.pollFirst());
            j++;
        }
    }
    private void transfer(LinkedList<Integer> s3, LinkedList<Integer> s1, int length){
        for(int i = 0; i < length; i++){
            s1.offerFirst(s3.pollFirst());
        }
    }
}
