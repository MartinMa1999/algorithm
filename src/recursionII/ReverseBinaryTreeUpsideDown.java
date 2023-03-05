package recursionII;

public class ReverseBinaryTreeUpsideDown {
    public TreeNode reverse(TreeNode root){
        if(root == null){
            return root;
        }

        TreeNode subProblem = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;

        return subProblem;
    }
}
