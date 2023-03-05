package crossTrainingI;

public class LCAInBSTI {
    public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
        int min = Math.min(one.key, two.key);
        int max = Math.max(one.key, two.key);

        while(root != null){
            if(root.key < min){
                root = root.right;
            }
            else if(root.key > min){
                root = root.left;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
