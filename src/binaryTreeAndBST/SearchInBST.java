package binaryTreeAndBST;

public class SearchInBST {
    public TreeNode search(TreeNode root, int key){
        if(root == null){
            return null;
        }

        while(root != null){
            if(root.key < key){
                root = root.right;
            }
            else if(root.key > key){
                root = root.left;
            }
            else{
                return root;
            }
        }

        return null;
    }
}
