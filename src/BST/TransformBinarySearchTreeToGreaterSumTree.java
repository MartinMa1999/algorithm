package BST;

public class TransformBinarySearchTreeToGreaterSumTree {
    // Given a BST, change each node’s value, such that its value is equal to the sum of all nodes greater than itself.

    //典型右根左，如果是改成smaller就是正常的inorder traversal

    public TreeNode greaterSum(TreeNode root) {
        if(root == null){
            return null;
        }

        calculateAll(root, new int[1]);
        return root;
    }
    private void calculateAll(TreeNode root, int[] sum){
        if(root == null){
            return;
        }
        calculateAll(root.right, sum);
        int tmp = root.key;
        root.key = sum[0];
        sum[0] += tmp;

        calculateAll(root.left, sum);

    }
}
