package crossTrainingI;

import java.util.List;

public class LCAIV {
    public TreeNode LCA(TreeNode root, List<TreeNode> nodes){
        //assume root != null and all nodes in same tree
        if(root == null || nodes.contains(root)){
            return root;
        }

        TreeNode left = LCA(root.left, nodes);
        TreeNode right = LCA(root.right, nodes);

        if(left != null && right != null){
            return root;
        }

        return root.left != null ? root.left : root.right;
    }

}
