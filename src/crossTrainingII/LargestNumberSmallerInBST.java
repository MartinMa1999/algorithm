package crossTrainingII;

public class LargestNumberSmallerInBST {
    public int largest(TreeNode root, int target){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int result = root.key;
        while(root != null){
            if(root.key < target){
                result = root.key;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        return result >= target ? Integer.MIN_VALUE : result;
    }
}
