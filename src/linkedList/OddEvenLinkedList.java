package linkedList;

public class OddEvenLinkedList {
    // Given a singly linked list, group all odd nodes together followed by the even nodes.
    // Please note here we are talking about the node number and not the value in the nodes.
    //
    //You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            cur1.next = cur;
            cur1 = cur1.next;
            cur2.next = cur.next;
            cur2 = cur2.next;
            cur = cur.next.next;
        }
        if(cur != null){
            cur1.next = cur;
            cur1 = cur1.next;
        }

        cur2.next = null;

        cur1.next = dummy2.next;
        return dummy1.next;


    }
}
