package recursionIII;

import java.util.Map;

public class MaximumPathSumBinaryTreeIII {
    //Find the maximum possible sub-path sum
    // (both the starting and ending node of the sub-path should be on the same path from root to one of the leaf nodes,
    // and the sub-path is allowed to contain only one node).

    public int max(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int[] max = new int[]{Integer.MIN_VALUE};
        findAll(root, max);
        return max[0];
    }
    private int findAll(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = Math.max(findAll(root.left, max), 0);
        int right = Math.max(findAll(root.right, max), 0);

        max[0] = Math.max(max[0], Math.max(left, right) + root.val);

        return Math.max(left, right) + root.val;
    }
}
