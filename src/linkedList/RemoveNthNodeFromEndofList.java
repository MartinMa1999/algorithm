package linkedList;

public class RemoveNthNodeFromEndofList {
    // Given a linked list, remove the nth node from the end of list and return its head
    // Try to do this in one pass

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int count = 0;
        while(fast != null && count < n){
            fast = fast.next;
            count++;
        }
        if(count < n){
            return head;
        }

        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev != null){
            prev.next = slow.next;
            return head;
        }

        return slow.next;

    }
}
