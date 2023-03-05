package linkedList;

public class ReverseLinkedList {
    //iterative way
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
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
    //recursion
    public ListNode reverseMethodTwo(ListNode head){
        if(head == null || head.next == null){
            return null;
        }

        ListNode newHead = reverseMethodTwo(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
