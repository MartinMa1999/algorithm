package linkedList;

public class DeleteNodeAtIndex {
    // Delete the node at the given index for the given linked list.

    public ListNode deleteNode(ListNode head, int index) {
        if(head == null){
            return null;
        }
        if(index < 0){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while(index > 0){
            if(cur == null){
                break;
            }

            prev = cur;
            cur = cur.next;
            index--;
        }

        if(prev == null){
            return cur.next;
        }

        if(cur == null){
            return head;
        }

        prev.next = cur.next;
        cur.next = null;

        return head;
    }
}
