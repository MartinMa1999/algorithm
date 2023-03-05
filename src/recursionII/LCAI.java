package recursionII;

public class LCAI {
    public TreeNode checkLCA(TreeNode root, TreeNode one, TreeNode two){
        // check if two nodes in different trees
        TreeNode result = LCA(root, one, two);
        if(result == one || result == two){
            if(LCA(result.left, one, two) == null && LCA(result.right, one, two) == null){
                return null;
            }
        }
        return result;
    }
    public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || root == one || root == two){
            return root;
        }

        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one, two);

        if(left == null || right == null){
            return left == null ? right : left;
        }

        return root;
    }
}

class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
 }
