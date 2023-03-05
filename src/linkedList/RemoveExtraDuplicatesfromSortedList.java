package linkedList;

public class RemoveExtraDuplicatesfromSortedList {
    // Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    public ListNode removeDup(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null && cur.next != null){
            if(cur.next.value != cur.value){
                prev = cur;
            }
            else{
                while(cur.next != null && cur.next.value == cur.value){ // 注意cur有可能会指向null
                    cur = cur.next;
                }
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        prev.next = cur;

        return dummy.next;
    }
}
