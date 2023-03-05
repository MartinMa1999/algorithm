package Tree;

public class BinaryTreePathSumToTargetI {
    // Given a binary tree and a target sum,
    // determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.

    public boolean exist(TreeNode root, int target) {
        if(root == null){
            return false;
        }
        int perfix = 0;
        return findAll(root, perfix, target);
    }
    private boolean findAll(TreeNode root, int perfix, int target){
        if(root == null){
            return false;
        }

        perfix += root.key;
        if(perfix == target && root.left == null && root.right == null){
            return true;
        }

        if(findAll(root.left, perfix, target)){
            return true;
        }

        if(findAll(root.right, perfix, target)){
            return true;
        }

        return false;
    }
}
