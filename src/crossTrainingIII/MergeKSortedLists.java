package crossTrainingIII;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeSort(List<ListNode> input){
        //assume input cannot be null and size > 0
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>();
        for(ListNode node : input){
            minHeap.offer(node);
        }

        ListNode head = minHeap.poll();
        ListNode cur = head;
        if(head.next != null){//有可能head下一个是null
            minHeap.offer(head.next);
        }

        while(! minHeap.isEmpty()){
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;
            if(tmp.next != null){
                minHeap.offer(tmp.next);
            }
        }
        return head;
    }

}

class ListNode implements Comparable{
   public int value;
   public ListNode next;
   public ListNode(int value) {
     this.value = value;
     next = null;
   }

    @Override
    public int compareTo(Object o) {
        if(o instanceof ListNode tmp){
            if(tmp.value == this.value){
                return 0;
            }
            return this.value < tmp.value ? -1 : 1;
        }
        else{
            throw new RuntimeException("wrong type");
        }
    }
}