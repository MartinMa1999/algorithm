package recursionIII;

public class MaximumPathSumLeafToRoot {
    public int max(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return findAll(root);
    }
    private int findAll(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = findAll(root.left);
        int right = findAll(root.right);

        //必须考虑如果有一边的子树为空，此时因为是leaf to root，所以必须走有的那边
        if(root.left == null){
            return right + root.val;
        }

        if(root.right == null){
            return left + root.val;
        }

        return Math.max(left,right) + root.val;
    }
}
