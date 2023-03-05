package Tree;

public class ConnectRightPointerToSuccessor {
    // Connect the node whose right child is NULL to the successor node in in-order sequence.

    // 用prev存上一个right为null的元素，并和下一个被traverse到的元素相连接
    public void connect(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode[] prev = new TreeNode[1];
        changeAll(root, prev);
    }
    private void changeAll(TreeNode root, TreeNode[] prev){
        if(root == null){
            return;
        }
        changeAll(root.left, prev);
        if(prev[0] != null){
            prev[0].right = root;
            prev[0] = null;
        }

        if(root.right == null){
            prev[0] = root;
        }

        changeAll(root.right, prev);
    }
}
