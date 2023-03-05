package crossTrainingII;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode deepCopy(RandomListNode root){
        if(root == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(root.value);
        map.put(root,newHead);
        RandomListNode cur = newHead;
        while(root != null){
            if(root.next != null){
                if(! map.containsKey(root.next)){
                    map.put(root.next, new RandomListNode(root.next.value));
                }
                cur.next = map.get(root.next);
            }

            if(root.random != null){
                if(! map.containsKey(root.random)){
                    map.put(root.random, new RandomListNode(root.random.value));
                }
                cur.random = map.get(root.random);
            }

            root = root.next;
            cur = cur.next;
        }
        return newHead;
    }
}
class RandomListNode {
   public int value;
   public RandomListNode next;
   public RandomListNode random;
   public RandomListNode(int value) {
     this.value = value;
   }
 }