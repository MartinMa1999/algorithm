package MorrisTraversal;

import java.util.ArrayList;
import java.util.List;


public class PostOrder {
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
        PostOrder postOrder = new PostOrder();
        postOrder.postOrderTraversal(root);
    }

    public List<Integer> postOrderTraversal(TreeNode root){ // 算法逻辑相当于，把整个树斜着print出来，每次都打印右下到左上的整个branch
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
                    cur = cur.left;
                }
                else{
                    bridgeNode.right = null;
                    printAll(cur.left, result);// 逆序打印所有左子树的最右，因为是post order，所以最后一定是这个顺序
                    cur = cur.right;
                }
            }
            else{
                cur = cur.right;
            }
        }

        printAll(root, result);
        return result;
    }
    private TreeNode findIt(TreeNode root, TreeNode node){
        while(node.right != null && node.right != root){
            node = node.right;
        }
        return node;
    }

    private void printAll(TreeNode node, List<Integer> result){
        TreeNode head = reverseRight(node);
        TreeNode cur = head;
        while(cur != null){
            result.add(cur.val);
            cur = cur.right;
        }
        reverseRight(head);
    }

    private TreeNode reverseRight(TreeNode node){
        TreeNode cur = node;
        TreeNode prev = null;
        while(cur != null){
            TreeNode next = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
