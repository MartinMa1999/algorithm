package heapAndGraphSearch_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> getKeys(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);

        while(! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode tmp = queue.poll();
                list.add(tmp.key);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                size--;
            }
            result.add(list);
        }
        return result;
    }
}

class TreeNode{
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int key){
        this.key = key;
    }
}
