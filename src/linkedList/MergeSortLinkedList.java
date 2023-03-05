package linkedList;

public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(newHead);
        return merge(left, right);
    }
    private ListNode merge(ListNode left, ListNode right){
        if(left == null || right == null){
            return left == null ? right : left;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(left != null && right != null){
            if(left.value < right.value){
                cur.next = left;
                left = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        //不需要再单独连，因为本来就是连着的
        cur.next = left != null ? left : right;

        return dummy.next;
    }
}
