//package hashTableAndStringI;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//public class MyOwnHashMap <K, V>{
//    static class Node <K, V>{
//        final K key;
//        V value;
//        Node<K, V> next;
//        Node(K key, V value){
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V val){
//            value = val;
//        }
//    }
//
//    private static final int DEFAULT_CAPACITY = 16;
//    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
//    private Node<K, V>[] array;
//    private int size;
//    private float loadFactor;
//
//    MyOwnHashMap(int cap, float loadFactor){
//        if(cap <= 0){
//            throw new IllegalArgumentException("capacity must be > 0");
//        }
//
//        this.array = (Node<K, V>[]) (new Node[cap]);
//        this.loadFactor = loadFactor;
//    }
//
//    MyOwnHashMap(){
//        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
//    }
//
//    public int size(){
//        return size;
//    }
//
//    public boolean isEmpty(){
//        return size == 0;
//    }
//
//    public void clear(){
//        Arrays.fill(this.array, null);
//        size = 0;
//    }
//    private int hash(K key){
//        if(key == null){
//            return 0;
//        }
//        return key.hashCode() & 0x7FFFFFFF;
//    }
//
//    private int getIndex(K key){
//        return hash(key) % array.length;
//    }
//
//    private boolean equalsValue(V v1, V v2){
//        if(v1 == null && v2 == null){
//            return true;
//        }
//
//        if(v1 == null || v2 == null){
//            return false;
//        }
//
//        return v1.equals(v2);
//    }
//
//    public boolean containsValue(V value){
//        if(isEmpty()){
//            return false;
//        }
//
//        for(Node<K, V> node : array){
//            while(node != null){
//                if(equalsValue(node.getValue(), value)){
//                    return true;
//                }
//                node = node.next;
//            }
//        }
//        return false;
//    }
//
//    private boolean equalsKey(K key1, K key2){
//        if(key1 == null && key2 == null){
//            return true;
//        }
//
//        if(key1 == null || key2 == null){
//            return false;
//        }
//
//        return key1.equals(key2);
//    }
//
//    public boolean containsKey(K key){
//        if(isEmpty()){
//            return false;
//        }
//
//        int index = getIndex(key);
//        Node<K, V> node = array[index];
//        while(node != null){
//            if(equalsKey(node.getKey(), key)){
//                return true;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//
//    public V get(K key){
//        if(isEmpty()){
//            return null;
//        }
//
//        int index = getIndex(key);
//        Node<K, V> node = array[index];
//        while(node != null){
//            if (equalsKey(node.getKey(), key)) {
//                return node.getValue();
//            }
//            node = node.next;
//        }
//        return null;
//    }
//
//    public V put(K key, V value){
//        int index = getIndex(key);
//        Node<K, V> head = array[index];
//        Node<K, V> node = head;
//        while(node != null){
//            if(equalsKey(node.getKey(), key)){
//                V val = node.getValue();
//                node.setValue(value);
//                return val;
//            }
//            node = node.next;
//        }
//
//        Node<K, V> newNode = new Node<>(key,value);
//        newNode.next = head;
//        array[index] = newNode;
//        size++;
//        if(needRehashing()){
//            rehashing();
//        }
//
//        return null;
//    }
//
//    private boolean needRehashing(){
//        return  ((size + 0.0 / array.length) - loadFactor) >= 0;
//    }
//
//    private void rehashing(){
//        int cap = array.length * 2;
//        Node<K, V>[] old = array;
//        array = (Node<K, V>[])(new Node<>[cap]);
//
//        for(Node<K, V> node : old){
//            while(node != null){
//                Node<K, V> next = node.next;
//                int index = getIndex(node.getKey());
//                node.next = array[index];
//                array[index] = node;
//                node = next;
//            }
//        }
//    }
//
//    public V remove(K key){
//        if(isEmpty()){
//            return null;
//        }
//
//        int index = getIndex(key);
//        Node<K, V> node = array[index];
//        Node<K, V> prev = null;
//        while(node != null){
//            if(equalsKey(node.getKey(), key)){
//                if(prev != null){
//                    prev.next = node.next;
//                }
//                else{
//                    array[index] = node;
//                }
//                return node.getValue();
//            }
//            prev = node;
//            node = node.next;
//        }
//        return null;
//    }
//}
