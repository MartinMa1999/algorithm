package binaryTreeAndBST;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
       if(left == null && right == null){
           return true;
       }
       if(left == null || right == null || left.key != right.key){
           return false;
       }
        //本质上相当于直接比较了parameter的值是否相等
       return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
