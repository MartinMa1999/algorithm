package crossTrainingIV;

import java.util.HashMap;
import java.util.Map;

public class ImplementLRUCache<K, V> {
    static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private int limit;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> map;
    public ImplementLRUCache(int limit){
        this.limit = limit;
        map = new HashMap<>();
    }

    public void set(K key, V value){
        Node<K, V> node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        }
        else if(map.size() < limit){
            node = new Node<>(key, value);
        }
        else{
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }
    private void remove(Node<K, V> node){
        map.remove(node.key);
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;
        if(prev != null){
            prev.next = next;
        }
        if(next != null){
            next.prev = prev;
        }
        if(node == head){
            head = null;
        }
        if(node == tail){
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }
    private void append(Node<K, V> node){
        map.put(node.key, node);
        if(head == null){
            head = tail = node;
        }
        else{
            Node<K, V> tmp = head;
            tmp.next = node;
            node.prev = tmp;
            head = node;
        }
    }

    public V get(K key){//getter也要更新
        if(! map.containsKey(key)){
            return null;
        }
        Node<K, V> node = map.get(key);
        remove(node);
        append(node);
        return map.get(key).value;
    }
}
