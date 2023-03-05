package Tree;

public class CountCompleteTreeNodes {
    // Given a complete binary tree, count the number of nodes.

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    public int another(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = leftHeight(root);
        int right = rightHeight(root);
        if(left == right) {
            return (int)Math.pow(2,left) - 1;
        }
        return another(root.left) + another(root.right) + 1;
    }
    private int leftHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return leftHeight(root.left) + 1;
    }
    private int rightHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return rightHeight(root.right) + 1;
    }
}