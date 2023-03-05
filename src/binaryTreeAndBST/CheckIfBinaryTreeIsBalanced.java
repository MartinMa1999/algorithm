package binaryTreeAndBST;

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root){
        return getHeightOrUnbalanced(root) >= 0;
    }
    private int getHeightOrUnbalanced(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftResult = getHeightOrUnbalanced(root.left);
        int rightResult = getHeightOrUnbalanced(root.right);

        if(leftResult == -1 || rightResult == -1){
            return -1;
        }
        if(Math.abs(leftResult - rightResult) > 1){
            return -1;
        }

        return Math.max(leftResult, rightResult) + 1;
    }
}
