package linkedList;

public class CheckIfLinkedListIsPalindrome {
    //assume there are no parent parameter in the class ListNode
    public boolean check(ListNode head){
        if(head == null || head.next == head){
            return true;
        }

        ListNode slow = findMid(head);
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode reverseHead = reverse(newHead);

        return check(head, reverseHead);
    }
    private ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head){
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

    private boolean check(ListNode node1, ListNode node2){
        while(node1 != null && node2 != null){
            if(node1.value != node2.value){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
