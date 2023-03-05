package linkedList;

public class AddTwoNumbers {
    //assume that you don't need to reverse the result  2->4->3 + 5->6->4 = 7->0->8
    public ListNode addTwoNumbers(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int count = 0;
        while(node1 != null && node2 != null){
            int tmp = node1.value + node2.value + count;
            if(tmp < 10){
                cur.next = new ListNode(tmp);
                count = 0;
            }
            else{
                cur.next = new ListNode(tmp % 10);
                count = 1;
            }
            cur = cur.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        ListNode newCur = node1 == null ? node2 : node1;
        if(newCur != null){
            while(newCur != null){
                int tmp = newCur.value + count;
                if(tmp < 10){
                    cur.next = new ListNode(tmp);
                    count = 0;
                }
                else{
                    cur.next = new ListNode(tmp % 10);
                    count = 1;
                }
                newCur = newCur.next;
                cur = cur.next;
            }
        }

        if(count == 1){
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

    public ListNode easierWay(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int value = 0;

        while(node1 != null || node2 != null || value != 0){
            if(node1 != null){
                value += node1.value;
                node1 = node1.next;
            }

            if(node2 != null){
                value += node2.value;
                node2 = node2.next;
            }

            cur.next = new ListNode(value % 10);
            value = value / 10;
            cur = cur.next;
        }

        return dummy.next;
    }
}
