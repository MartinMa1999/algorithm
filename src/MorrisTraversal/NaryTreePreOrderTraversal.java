package MorrisTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NaryTreePreOrderTraversal {

    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        Node node7 = new Node(7);
//        Node node8 = new Node(8);
//        Node node9 = new Node(9);
//        Node node10 = new Node(10);
//        Node node11 = new Node(11);
//        Node node12 = new Node(12);
//        Node node13 = new Node(13);
//        Node node14 = new Node(14);
//        node1.children.add(node2);
//        node1.children.add(node3);
//        node1.children.add(node4);
//        node1.children.add(node5);
//        node3.children.add(node6);
//        node3.children.add(node7);
//        node4.children.add(node8);
//        node5.children.add(node9);
//        node5.children.add(node10);
//        node7.children.add(node11);
//        node8.children.add(node12);
//        node9.children.add(node13);
//        node11.children.add(node14);

        Node node1 = new Node(3);
        Node node2 = new Node(1);
        Node node3 = new Node(5);
        node1.children.add(node2);
        node2.children.add(node3);
        NaryTreePreOrderTraversal naryTreePreOrderTraversal = new NaryTreePreOrderTraversal();
        naryTreePreOrderTraversal.preOrderTraversal(node1);
    }
    public List<Integer> preOrderTraversal(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<Integer> counterStack = new ArrayDeque<>();
        Deque<Node> nodeStack = new ArrayDeque<>();
        counterStack.offerFirst(0);
        nodeStack.offerFirst(root);
        Node cur = root;
        while(! nodeStack.isEmpty()){
            List<Node> children = cur.children;
            if(counterStack.peekFirst() == 0){
                result.add(cur.val);
                if(children.isEmpty()){
                    break;
                }
                for(int i = 0; i < children.size() - 1; i++){
                    Node node = findLast(cur, children.get(i));
                    node.children.add(cur);
                }
                counterStack.offerFirst(counterStack.pollFirst() + 1);
                if(nodeStack.peekFirst().children.size() == counterStack.peekFirst()){
                    nodeStack.pollFirst();
                    counterStack.pollFirst();
                    if(nodeStack.isEmpty() || children.get(children.size() - 1).val != nodeStack.peekFirst().val) {
                        nodeStack.offerFirst(children.get(0));
                        counterStack.offerFirst(0);
                    }
                }
                else{
                    nodeStack.offerFirst(children.get(counterStack.peekFirst() - 1));
                    counterStack.offerFirst(0);
                }
            }
            else {
                Node node = findLast(cur, children.get(counterStack.peekFirst() - 1));
                node.children.remove(node.children.size() - 1);
                if(counterStack.peekFirst() != children.size() - 1){
                    counterStack.offerFirst(counterStack.pollFirst() + 1);
                    nodeStack.offerFirst(children.get(counterStack.peekFirst() - 1));
                    counterStack.offerFirst(0);
                }
                else{
                    nodeStack.pollFirst();
                    nodeStack.offerFirst(children.get(children.size() - 1));
                    counterStack.pollFirst();
                    counterStack.offerFirst(0);
                }
            }
            cur = nodeStack.peekFirst();

        }

        return result;
    }

    private Node findLast(Node root, Node node){
        while(!node.children.isEmpty() && !node.children.contains(root)){
            node = node.children.get(node.children.size() - 1);
        }

        return node;
    }
}

