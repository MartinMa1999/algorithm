package crossTrainingDIY;

public class MaximumPathSumBinaryTreeI {
    // Given a binary tree in which each node contains an integer number.
    // Find the maximum possible sum from one leaf node to another leaf node.
    public int maxPathSum(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        findAll(root,max);
        return max[0];
    }
    private int findAll(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = findAll(root.left, max);
        int right = findAll(root.right, max);
        if(root.left == null){
            return right + root.key;
        }
        if(root.right == null){
            return left + root.key;
        }

        int tmp = left + right + root.key;
        max[0] = Math.max(max[0], tmp);
        return Math.max(left, right) + root.key;

    }
}
