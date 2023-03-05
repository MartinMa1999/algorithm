package crossTrainingDIY;

public class CycleNodeInLinkedList {
    //第一次相遇后让slow从头开始，fast走一步，第二次相遇就是target
    public ListNode cycleNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean visited = false;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            if(! visited){
                fast = fast.next.next;
            }
            else{
                fast = fast.next;
            }

            if (slow == fast && ! visited){
                slow = head;
                visited = true;
            }
            if(slow == fast && visited){//不能是else if,因为有可能此时的fast就在head处，这样会出bug
                return slow;
            }
        }
        return null;
    }
}
