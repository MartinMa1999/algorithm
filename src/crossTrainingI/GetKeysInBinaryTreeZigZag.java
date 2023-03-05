package crossTrainingI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetKeysInBinaryTreeZigZag {
    public List<Integer> zigZag(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int count = 1;
        while(! deque.isEmpty()){
            int size = deque.size();
            if(count == 0){
                for(int i = 0; i < size; i++){
                    TreeNode tmp = deque.pollFirst();
                    result.add(tmp.key);
                    if(tmp.left != null){
                        deque.offerLast(tmp.left);
                    }
                    if(tmp.right != null){
                        deque.offerLast(tmp.right);
                    }
                }
            }
            else{
                for(int i = 0; i < size; i++){
                    TreeNode tmp = deque.pollLast();
                    result.add(tmp.key);
                    if(tmp.right != null){
                        deque.offerFirst(tmp.right);
                    }
                    if(tmp.left != null){
                        deque.offerFirst(tmp.left);
                    }
                }
            }
            count = 1 - count;
        }
        return result;
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