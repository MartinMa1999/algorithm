package linkedList;

public class MergeTwoSortedLinkedList {
    public ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }

        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(cur1 != null && cur2 != null){
            if(cur1.value < cur2.value){
                cur.next = cur1;
                cur1 = cur1.next;
            }
            else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        cur.next = cur1 != null ? cur1 : cur2;

        return dummy.next;
    }
}
