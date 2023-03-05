package crossTrainingDIY;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class QuickSortLinkedList {
    public static void main(String[] args) {
        QuickSortLinkedList test = new QuickSortLinkedList();
        ListNode root = new ListNode(5);
        root.next = new ListNode(4);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next = new ListNode(3);
        test.quickSort(root);
    }
    public ListNode quickSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        return quickSort(head, count);
    }
    private ListNode quickSort(ListNode head, int count){
        if(count == 0){
            return null;
        }
        if(count == 1) {
            return head;
        }

        Random random = new Random();
        int pivotIndex = random.nextInt(count);
        int i = 0;
        ListNode cur = head;
        while(i < pivotIndex){
            cur = cur.next;
            i++;
        }

        ListNode tmp = cur;
        int value = cur.value;

        ListNode dummy1 = new ListNode(-1);
        ListNode cur1 = dummy1;
        int count1 = 0;

        ListNode dummy2 = new ListNode(-1);
        ListNode cur2 = dummy2;
        int count2 = 0;

        cur = head;
        while(cur != null){
            if(cur != tmp){
                if(cur.value <= value){
                    cur1.next = cur;
                    cur1 = cur1.next;
                    count1++;
                }
                else {
                    cur2.next = cur;
                    cur2 = cur2.next;
                    count2++;
                }
            }
            cur = cur.next;
        }
        cur1.next = null;
        cur2.next = null;
        ListNode left = quickSort(dummy1.next, count1);
        ListNode right = quickSort(dummy2.next, count2);
        if(left != null){
            cur = left;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = tmp; // bug!这里必须是cur而不是left
        }
        tmp.next = right;
        return left == null ? tmp : left;
    }
}
