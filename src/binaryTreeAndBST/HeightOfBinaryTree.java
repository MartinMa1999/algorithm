package binaryTreeAndBST;

public class HeightOfBinaryTree {
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftResult = getHeight(root.left);
        int rightResult = getHeight(root.right);

        return Math.max(leftResult,rightResult) + 1;
    }
}
