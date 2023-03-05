package linkedList;

public class InsertInSortedList {
    public ListNode insert(ListNode head, int value){
        //assume all nodes are sorted in ascending order
        ListNode node = new ListNode(value);
        if(head == null || node.value < head.value){
            node.next = head;
            return node;
        }

        ListNode cur = head;
        ListNode prev = null;
        while(cur != null && cur.value < value){
            prev = cur;
            cur = cur.next;
        }

        if (cur != null) {
            node.next = prev.next;
        }
        prev.next = node;

        return head;
    }
}
