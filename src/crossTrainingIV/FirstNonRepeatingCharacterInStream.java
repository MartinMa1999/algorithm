package crossTrainingIV;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacterInStream {
    // Given a stream of characters, find the first non-repeating character from stream.
    // You need to tell the first non-repeating character in O(1) time at any moment.
    // 设计逻辑是一个循环的listNode，其中head永远是null，每次动tail，相当于dummy head
    static class Node{
        Character c;
        Node next;
        Node prev;
        Node(Character c){
            this.c = c;
        }
    }

    Set<Character> set = new HashSet<>();
    Map<Character, Node> map = new HashMap<>();
    Node head;
    Node tail;

    FirstNonRepeatingCharacterInStream(){
        tail = new Node(null);
        tail.next = tail.prev = tail;
        head = tail;
    }

    public void read(char c){
        if(set.contains(c)){
            return;
        }

        Node node = map.get(c);
        if (node == null){
            node = new Node(c);
            append(node);
        }
        else{
            remove(node);
        }
    }

    private void append(Node node){
        map.put(node.c, node);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = tail.next;
    }

    private void remove(Node node){
        map.remove(node.c);
        set.add(node.c);

        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == tail){
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

    public Character firstNonRepeating(){
        if(head == null){
            return null;
        }
        return head.next.c;
    }

}
