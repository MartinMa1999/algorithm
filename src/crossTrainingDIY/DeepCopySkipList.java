package crossTrainingDIY;

import java.util.HashMap;
import java.util.Map;

public class DeepCopySkipList {
    // A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front
    // and forward pointers are guaranteed to be in non-descending order.
    // 如果forward都指向后面，则map没必要存用next遍历到的元素，因为你走过去了之后再也看不到他了

    public SkipListNode copy(SkipListNode head) {
        if(head == null){
            return null;
        }
        Map<SkipListNode, SkipListNode> map = new HashMap<>();
        SkipListNode newHead = new SkipListNode(head.value);
        map.put(head, newHead);
        SkipListNode cur = newHead;
        while(head != null){
            if(head.forward != null){
                if(! map.containsKey(head.forward)){
                    cur.forward = new SkipListNode(head.forward.value);
                    map.put(head.forward, cur.forward);
                }
                else{
                    cur.forward = map.get(head.forward);
                }
            }

            if(head.next != null){
                if(map.containsKey(head.next)){
                    cur.next = map.get(head.next);
                }
                else{
                    cur.next = new SkipListNode(head.next.value);
                }
            }
            cur = cur.next;
            head = head.next;
        }
        return newHead;

    }
}

class SkipListNode {
   public int value;
   public SkipListNode next;
   public SkipListNode forward;
   public SkipListNode(int value) {
     this.value = value;
   }
 }