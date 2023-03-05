package linkedList;

public class ReOrderLinkedList {
    //find the mid, reverse the latter one, merge to LinkedList
    public ListNode reOrder(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        ListNode latter = reverse(newHead);

        ListNode cur1 = head;
        ListNode cur2 = latter;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(cur1 != null && cur2 != null){
            cur.next = cur1;
            cur1 = cur1.next;
            cur.next.next = cur2;
            cur2 = cur2.next;
            cur = cur.next.next;
        }
        if(cur1 != null){// if the number of nodes is odd
            cur.next = cur1;
        }

        return dummy.next;
    }
    private ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
