package linkedList;

public class RemoveLinkedListElements {
    public ListNode remove(ListNode head, int target){
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cur1 = head;
        while(cur1 != null){
            if(cur1.value != target){
                cur.next = cur1;
                cur = cur.next;
            }
            cur1 = cur1.next;
        }

        cur.next = null;//必须断掉后面的，否则有可能还连着不需要的东西
        return dummy.next;
    }
}
