package Tree;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

public class BorderViewOfBinaryTree {
    // Given a binary tree, return its border view. The border view is defined as follows:
    // first get all the border nodes at left side(from root and always go to the left subtree unless the left subtree
    // does not exist until reach a leaf node), then get all the leaf nodes(from left to right),
    // at last get all the border nodes at right side(similar to left border but from bottom to top),
    // the list of border view should not contain duplicate nodes. Note that for the given root,
    // if it has no left subtree or right subtree, it is considered the left border/right border,
    // but this rule applies to only the input tree not any subtree of it.

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node9;
        node6.right = node8;
        node9.right = node11;

        BorderViewOfBinaryTree test = new BorderViewOfBinaryTree();
        test.borderView(node1);
    }

    //本题逻辑为，找到左右的左边，右边和leaf，所以把树直接砍成两半，左边走找左边的，右边走找右边的，但是因为右边的顺序相反，所以对左边来说可以一边走一边
    // 添加值，而对右边来说就需要先走到底再添加。

    public List<Integer> borderView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.key);
        findAll(root.left, true, false, result);
        findAll(root.right, false, true, result);
        return result;
    }

    private void findAll(TreeNode root, boolean left, boolean right, List<Integer> result){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(root.key);
            return;
        }

        if(left){
            result.add(root.key);
        }
        findAll(root.left, left && root.left != null, right && root.right == null, result);
        findAll(root.right, left && root.left == null, right && root.right != null, result);
        if(right){
            result.add(root.key);
        }
    }
}
