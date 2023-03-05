package BST;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class KthSmallestElementinaBST {
    // Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    // assume k is valid

    //BST中inorder traverse一定是natural order的
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != null || ! stack.isEmpty()){
            if(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pollFirst();
                k--;
                if(k == 0){
                    break;
                }
                cur = cur.right; // bug!!
            }
        }
        return cur.key;
    }
}
