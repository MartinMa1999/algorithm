package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelorderReconstructCompleteBinaryTree {
    // How to re construct a complete binary tree from its level-order traversal sequence only.

    public TreeNode construct(int[] level) {
        if(level == null || level.length == 0){
            return null;
        }

        int index = 1;
        TreeNode root = new TreeNode(level[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(index < level.length){
            TreeNode tmp = queue.poll();
            tmp.left = new TreeNode(level[index++]);
            queue.offer(tmp.left);
            if(index == level.length){
                break;
            }
            tmp.right = new TreeNode(level[index++]);
            queue.offer(tmp.right);
        }

        return root;
    }
}
