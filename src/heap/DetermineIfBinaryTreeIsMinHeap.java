package heap;

import java.util.ArrayDeque;
import java.util.Queue;

public class DetermineIfBinaryTreeIsMinHeap {

    // 组成minheap的tree有两个特点，一个是leaf都比root小，另外一个就是complete tree

    public boolean isMinHeap(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean visited = false;
        while(! queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left != null){
                if(tmp.left.key < tmp.key || visited){
                    return false;
                }
                queue.offer(tmp.left);
            }
            else{
                visited = true;
            }
            if(tmp.right != null){
                if(tmp.right.key < tmp.key || visited){
                    return false;
                }
                queue.offer(tmp.right);
            }
            else{
                visited = true;
            }
        }
        return true;
    }
}

class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
 }