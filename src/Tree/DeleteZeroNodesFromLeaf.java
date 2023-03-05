package Tree;

public class DeleteZeroNodesFromLeaf {

    // Given a binary tree, delete the nodes only if it is 0 and all the nodes on the paths from the node to any leaf nodes are all 0.
    //
    //In another word, delete the leaf nodes with 0 recursively until there are no such nodes in the tree.

    public TreeNode deleteZero(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode prev = null;
        return deleteAll(root, prev);
    }
    private TreeNode deleteAll(TreeNode root, TreeNode prev){
        if(root == null){
            return null;
        }
        TreeNode left = deleteAll(root.left, root); // bug!! 不能给prev赋值，否则下面的代码都会受到影响
        TreeNode right = deleteAll(root.right, root);

        if(left == null && right == null && root.key == 0){
            if(prev != null){
                if(root == prev.left){
                    prev.left = null;
                }
                else {
                    prev.right = null;
                }
            }
            return null; //bug！如果要删除元素，则返回的一定是个null，否则就返回他自己
        }
        return root;
    }
}
