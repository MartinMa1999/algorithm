package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class DetermineIfBinaryTreeIsFullTree {
    // Determine if a given binary tree is full.
    //
    //A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
    // Conversely, there is no node in a full binary tree, which has one child node.
    //
    //If the root is null, return false.

    public boolean isFull(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left != null && tmp.right != null){
                queue.offer(tmp.left);
                queue.offer(tmp.right);
                continue;
            }
            if(tmp.left != null || tmp.right != null){
                return false;
            }
        }
        return true;
    }
}
