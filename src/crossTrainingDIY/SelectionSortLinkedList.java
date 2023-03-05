package crossTrainingDIY;

public class SelectionSortLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3= new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        SelectionSortLinkedList test = new SelectionSortLinkedList();
        test.selectionSort(node1);

    }
    public ListNode selectionSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode oldPrev = null;
        while(cur != null){
            ListNode next = cur.next;

            ListNode tmp = cur;
            ListNode prev = null;

            ListNode min = cur;
            ListNode newPrev = null;
            while(tmp != null){
                if(tmp.value < min.value){
                    min = tmp;
                    newPrev = prev;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            if(oldPrev != null){
                oldPrev.next = min;
            }
            else {
                dummy.next = min;
            }
            if(newPrev != null){
                newPrev.next = cur;
            }
            cur.next = min.next;
            if(min == next){
                min.next = cur;
            }
            else{
                min.next = next;//bug,如果要交换的两个元素相邻的时候，就必须让next指向cur，否则就会next指向next，自己指向自己
            }


            oldPrev = min;
            cur = min.next;
        }
        return dummy.next;
    }
}
class ListNode {
   public int value;
   public ListNode next;
   public ListNode(int value) {
     this.value = value;
     next = null;
   }
 }