package heapAndGraphSearch_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCompleteBinaryTree {
    public boolean isComplete(TreeNode root){
        // level order traverse tree, if find null, visited = true;
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean visited = false;
        queue.offer(root);
        while(! queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left != null && !visited){
                queue.offer(tmp.left);
            }
            else if(tmp.left != null){
                return false;
            }
            else {
                visited = true;
            }

            if(tmp.right != null && !visited){
                queue.offer(tmp.right);
            }
            else if(tmp.right != null){
                return  false;
            }
            else{
                visited = true;
            }
        }
        return true;
    }
}
