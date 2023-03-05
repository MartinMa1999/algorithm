package crossTrainingII;

public class ClosetNumberInBST {
    public int closet(TreeNode root, int target){
        if(root == null){
            return -1;
        }

        int result = root.key;
        while(root != null){
            if(root.key < target){
                result = Math.abs(result - target) < Math.abs(root.key - target)? result : root.key;
                root = root.right;
            }
            else if(root.key > target){
                result = Math.abs(result - target) < Math.abs(root.key - target)? result : root.key;
                root = root.left;
            }
            else{
                return target;
            }
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