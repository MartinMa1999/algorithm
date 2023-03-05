package Tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        invert(root, root.left, root.right);
        return root;
    }

    private void invert(TreeNode root, TreeNode left, TreeNode right){
        if(left == null && right == null){
            return;
        }

        root.left = right;
        root.right = left;
        if(root.left != null){
            invert(root.left, root.left.left, root.left.right);
        }
        if(root.right != null){
            invert(root.right, root.right.left, root.right.right);
        }

    }
}
