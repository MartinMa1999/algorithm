package BST;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestInBinarySearchTree {
    // Find the second-largest key in the given binary search tree.

    // 需要考虑两种情况，第一种是走到最右边，即最大发现有左子树，这样就去他的左子树里找最右；如果最右边是个leaf，则返回他的prev值
    // array里面找第二大则是要每次都让首位比较大小，然后存比较对象，找到最大的之后去比较对象里面找最大的
    public int secondLargest(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.left == null && root.right == null){
            return Integer.MIN_VALUE;
        }

        TreeNode cur = root;
        TreeNode prev = null;
        while(cur.right != null){
            prev = cur;
            cur = cur.right;
        }
        if(cur.left != null){
            cur = cur.left;
        }
        else{
            return prev.key;
        }
        while(cur.right != null){
            cur = cur.right;
        }

        return cur.key;
    }
}
