package crossTrainingDIY;

public class LCAIII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        TreeNode LCA = LCA(root, one, two);
        if(LCA == null || (LCA != one && LCA != two)){
            return LCA;
        }
        TreeNode tmp = null;
        TreeNode tmp1 = null;
        TreeNode tmp2 = null;
        if(LCA == one){
            tmp1 = LCA(one.left, one, two);
            tmp2 = LCA(one.right, one, two);
        }
        else {
            tmp1 = LCA(two.left, one, two);
            tmp2 = LCA(two.right, one, two);
        }
        tmp = tmp1 == null ? tmp2 : tmp1;
        return tmp == null ? null : LCA;
    }
    private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || root == one || root == two){
            return root;
        }

        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one, two);
        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
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
