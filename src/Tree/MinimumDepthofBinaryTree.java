package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    // Given a binary tree, find its minimum depth.
    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 1;
        breakpoint:
        while(! queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    break breakpoint;
                }
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;
            }

            count++;
        }

        return count;

    }
}
