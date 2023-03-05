package recursionII;

public class ReverseLinkedListInPairs {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode subResult = reverse(head.next.next);
        ListNode next = head.next;
        head.next = subResult;
        next.next = head;
        return next;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
