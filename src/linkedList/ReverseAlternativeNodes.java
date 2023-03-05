package linkedList;

public class ReverseAlternativeNodes {
    // Given a linked list, reverse alternate nodes and append at the end.
    // Input List:    1 -> 2 -> 3 -> 4 -> 5 -> 6
    // Output List:   1 -> 3 -> 5 -> 6 -> 4 -> 2

    public ListNode reverseAlternate(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            cur1.next = cur;
            cur2.next = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next.next;
        }

        if(cur != null){
            cur1.next = cur;
            cur1 = cur1.next;
        }
        cur1.next = null;
        cur2.next = null;
        ListNode node = reverse(dummy2.next);
        cur1.next = node;

        return dummy1.next;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        head.next = null; // bug!!
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
