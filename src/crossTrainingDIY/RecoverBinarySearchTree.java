package crossTrainingDIY;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree {
    // Given a Binary Search Tree with only two nodes swapped. Try to find them and recover the binary search tree.
    // inorder traverse，找到两个值不对的情况
    TreeNode x = null;
    TreeNode y = null;
    TreeNode prev = null;
    public TreeNode recover(TreeNode root) {
        if(root == null){
            return null;
        }

        inOrder(root);
        swap(x, y);
        return root;
    }
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if (prev != null) {
            if (root.key < prev.key) {
                y = root;
                if (x == null) {
                    x = prev; //prev显然是值不对，所以一定会和后面的换，有可能是两个相邻的值互换了
                }
            }
        }
        prev = root;
        inOrder(root.right);
    }
    private void swap(TreeNode x, TreeNode y){
        int tmp = x.key;
        x.key = y.key;
        y.key = tmp;
    }

    public TreeNode iterative(TreeNode root) {
        if(root == null){
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || ! stack.isEmpty()){
            if(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pollFirst();
                if (prev != null) {
                    if (prev.key > cur.key) { // 每次换的都是i和j+1位置处的点
                        y = cur;
                        if (x == null) {
                            x = prev;
                        }
                    }
                }
                prev = cur;
                cur = cur.right;
            }
        }

        swap(x, y);
        return root;
    }
}
