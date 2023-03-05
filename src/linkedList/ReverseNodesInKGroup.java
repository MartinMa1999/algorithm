package linkedList;

public class ReverseNodesInKGroup {
    // Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    // If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    // You may not alter the values in the nodes, only nodes itself may be changed.

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        int tmp = k;
        while(tmp > 0 && cur != null){
            prev = cur;
            cur = cur.next;
            tmp--;
        }

        if(tmp > 0){
            return head;
        }
        prev.next = null; // 注意可能有环
        ListNode sub = reverseKGroup(cur, k);
        ListNode result = reverse(head, prev);
        head.next = sub;
        return result;
    }

    private ListNode reverse(ListNode head, ListNode perv){
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
