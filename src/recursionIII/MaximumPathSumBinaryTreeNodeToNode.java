package recursionIII;

public class MaximumPathSumBinaryTreeNodeToNode {
    public int max(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int[] result = new int[]{Integer.MIN_VALUE};
        findAll(root, result);
        return result[0];
    }
    private int findAll(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }

        int left = Math.max(findAll(root.left, result), 0);
        int right = Math.max(findAll(root.right, result), 0);
        result[0] = Math.max(result[0], left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
