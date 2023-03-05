package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinsInBinaryTree {
    // Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not.
    // Two nodes are cousins of each other if they are at the same level and have different parents.

    // It is not guaranteed the two keys are all in the binary tree.
    // There are no duplicate keys in the binary tree.

    public boolean isCousin(TreeNode root, int a, int b) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            int size = queue.size();
            boolean one = false;
            boolean two = false;
            while(size > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    if(tmp.left.key == a || tmp.left.key == b){
                        if(tmp.right != null && (tmp.right.key == a || tmp.right.key == b)){
                            return false;
                        }
                        if(tmp.left.key == a){
                            one = true;
                        } else{
                            two = true;
                        }

                    }
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    if(tmp.right.key == a){
                        one = true;
                    }
                    if(tmp.right.key == b){
                        two = true;
                    }
                    queue.offer(tmp.right);
                }
                size--;
            }
            if(one && two){
                return true;
            }
        }

        return false;
    }
}
