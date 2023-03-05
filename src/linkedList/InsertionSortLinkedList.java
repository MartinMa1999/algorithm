package linkedList;

public class InsertionSortLinkedList {
    // Given a singly-linked list, where each node contains an integer value, sort it in ascending order.
    // The insertion sort algorithm should be used to solve this problem.

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        InsertionSortLinkedList test = new InsertionSortLinkedList();
        test.insertionSort(node1);
    }

    public ListNode insertionSort(ListNode head) {
        if(head == null || head.next== null){
            return head;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null){
            if(cur.value > prev.value){
                prev = cur;
                cur = cur.next;
            }
            else{
                ListNode prev1 = null;
                ListNode cur1 = head;
                ListNode next = cur.next;
                while(cur1.value < cur.value){
                    prev1 = cur1;
                    cur1 = cur1.next;
                }
                if(prev1 == null){
                    cur.next = head;
                    head = cur;
                }
                else{
                    prev1.next = cur;
                    cur.next = cur1;
                }
                cur = next;
                prev.next = cur;
            }
        }
        return head;
    }
}
