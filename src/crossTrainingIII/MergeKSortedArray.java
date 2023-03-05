package crossTrainingIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] mergeSort(int[][] matrix){
        // assume input cannot be null and length > 0
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                if(e1.val == e2.val){
                    return 0;
                }
                return e1.val < e2.val ? -1 : 1;
            }
        });
        int length = 0;
        for(int i = 0; i < matrix.length; i++){
            int[] element = matrix[i];
            length += element.length;
            if(element.length > 0){
                minHeap.offer(new Element(element[0], i, 0));
            }
        }

        int[] result = new int[length];
        int i = 0;
        while(! minHeap.isEmpty()){
            Element tmp = minHeap.poll();
            result[i++] = tmp.val;
            if(tmp.col < matrix[tmp.row].length - 1){
                minHeap.offer(new Element(matrix[tmp.row][tmp.col + 1], tmp.row, tmp.col + 1));
            }
        }

        return result;
    }
}
class Element{
    int val;
    int row;
    int col;
    Element(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
