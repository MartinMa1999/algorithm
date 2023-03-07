package MorrisTraversal;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(40);
        TreeNode node4 = new TreeNode(50);
        TreeNode node5 = new TreeNode(60);
        TreeNode node6 = new TreeNode(70);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        PreOrder preOrder = new PreOrder();
        preOrder.preOrderTraversal(root);
    }

    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode bridgeNode = findIt(cur, cur.left);
                if(bridgeNode.right == null){
                    bridgeNode.right = cur;
                    result.add(cur.val);
                    cur = cur.left;
                }
                else {
                    bridgeNode.right = null;
                    cur = cur.right;
                }
            }
            else {
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }

    private TreeNode findIt(TreeNode root, TreeNode node){
        while(node.right != null && node.right != root){
            node = node.right;
        }
        return node;
    }
}
