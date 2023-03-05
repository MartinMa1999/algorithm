package linkedList;

public class RotateListByKplaces {
    // Given a list, rotate the list to the right by k places, where k is non-negative.

    public ListNode rotateKplace(ListNode head, int n) {
        if(head == null || head.next == null){
            return head;
        }
        int length = findLength(head);
        int num = n % length;
        if(num == 0){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        int tmp = length - num;
        while(tmp > 0){
            prev = cur;
            cur = cur.next;
            tmp--;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
    private int findLength(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
