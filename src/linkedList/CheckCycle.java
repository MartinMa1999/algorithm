package linkedList;

public class CheckCycle {
    public boolean isCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
