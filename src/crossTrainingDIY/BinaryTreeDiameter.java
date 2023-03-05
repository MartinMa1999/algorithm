package crossTrainingDIY;

public class BinaryTreeDiameter {
    // Given a binary tree in which each node contains an integer number.
    // The diameter is defined as the longest distance from one leaf node to another leaf node.
    // The distance is the number of nodes on the path.

    public int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] max = new int[]{0};
        findAll(root, max);
        return max[0];
    }
    private int findAll(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = findAll(root.left, max);
        int right = findAll(root.right, max);
        if(left == 0){ //由于可能存在只有一支的情况，所以必须要判断有没有leaf node
            return right + 1;
        }
        if(right == 0){
            return left + 1;
        }
        max[0] = Math.max(max[0], left + right + 1);

        return Math.max(left, right) + 1;
    }
}
