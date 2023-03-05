package linkedList;

public class LinkedListInsertAtIndex {
    // Insert a new element at a specific index in the given linked list.
    // The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.

    public ListNode insert(ListNode head, int index, int value) {
        if(head == null){
            return new ListNode(value);
        }

        ListNode prev = null;
        ListNode cur = head;


        while(index > 0){
            if(cur == null){
                break;
            }
            else{
                prev = cur;
                cur = cur.next;
            }
            index--;
        }

        if(cur == null && index > 0){
            return head;
        }

        ListNode node = new ListNode(value);
        node.next = cur;

        if(prev == null){
            return node;
        }

        prev.next = node;
        return head;
    }
}
