package linkedList;

public class DeleteNodesAtIndices {
    // Given a linked list and an sorted array of integers as the indices in the list.
    // Delete all the nodes at the indices in the original list.

    public ListNode deleteNodes(ListNode head, int[] indices) {
        if(head == null || indices == null || indices.length == 0){
            return head;
        }

        int i = 0;
        int count = 0;
        int index = indices[indices.length - 1];
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        while(index > 0){
            if(cur == null){
                break;
            }

            if(count == indices[i]){
                prev.next = cur.next;
                cur = cur.next;
                i++;
            }
            else{
                prev = cur;
                cur = cur.next;
            }

            count++;
            index--;
        }

        if(cur == null){
            return dummy.next;
        }

        prev.next = cur.next;


        return dummy.next;
    }
}
