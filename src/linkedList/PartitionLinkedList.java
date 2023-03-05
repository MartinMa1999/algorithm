package linkedList;

public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target){
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        while(cur != null){
            if(cur.value < target){
                cur1.next = cur;
                cur1 = cur1.next;
            }
            else{
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        // break the connection between cur2 and its next
        cur2.next = null;
        cur1.next = dummy2.next;

        return dummy1.next;

    }
}
