package linkedList;

class MiddleNodeOfLinkedList {
    // two pointer
    public ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        // choose the former one if num is even
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // choose the latter one： fast != null && fast.next != null
        return slow;
    }
}
