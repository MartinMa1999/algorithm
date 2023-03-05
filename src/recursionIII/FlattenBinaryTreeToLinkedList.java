package recursionIII;

import com.sun.source.tree.Tree;

import java.util.Arrays;

public class FlattenBinaryTreeToLinkedList {
    // try to do it in-place
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(6);
//        TreeNode node5 = new TreeNode(8);
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node3.right = node5;
//        node2.left = node4;
//
//        }
//    }
    public TreeNode flatten(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode[] prev = new TreeNode[]{null};
        helper(root, prev);
        return root;
    }

    private void helper(TreeNode root, TreeNode[] prev){
        // preOrder traversal
        if(root == null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(prev[0] != null){
            prev[0].right = root;
        }

        root.left = null;
        prev[0] = root;

        helper(left, prev);
        helper(right, prev);
        //TC = O(n);
    }

    private TreeNode methodTwo(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = methodTwo(root.left);
        TreeNode right = methodTwo(root.right);

        root.left = null;
        root.right = left;
        TreeNode cur = root;

        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = right;

        return root;
        // TC = O(n^2)
    }

    // if in-order print:
    public TreeNode inOrder(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode[] prev = new TreeNode[1];

        return inOrder(root, prev);
    }
    private TreeNode inOrder(TreeNode root, TreeNode[] prev){
        if(root.left == null){
            if(prev[0] != null){
                prev[0].right = root;
            }
            prev[0] = root;
            if(root.right != null){//由于当左边没东西的时候，右边的就应该连在当前root的右侧，所以不需要给root.right赋值
                inOrder(root.right, prev);
            }
            return root;
        }

        TreeNode sub = inOrder(root.left, prev);
        prev[0].right = root;
        root.left = null;
        prev[0] = root;

        if(root.right != null){
            inOrder(root.right, prev);
        }

        return sub;
    }
}
