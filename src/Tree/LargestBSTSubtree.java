package Tree;

public class LargestBSTSubtree {
    // Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
    // where largest means subtree with largest number of nodes in it.

    // 重点在于bst一定要找左边最大和右边最小作为区间才可以
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] max = new int[1];
        findAll(root, max);
        return max[0];
    }

    private int findAll(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = findAll(root.left, max);
        int right = findAll(root.right, max);

        if(left == -1 || right == -1){
            return -1;
        }
        if(left == 0 && right == 0){
            max[0] = Math.max(max[0], 1);
            return 1;
        }

        if(left == 0){
            if(findMin(root.right) <= root.key){
                return -1;
            }
            max[0] = Math.max(max[0], right + 1);
            return right + 1;
        }

        if(right == 0){
            if(findMax(root.left) >= root.key){
                return -1;
            }
            max[0] = Math.max(max[0], left + 1);
            return left + 1;
        }

        if(findMax(root.left) >= root.key || findMin(root.right) <= root.key){
            return -1;
        }

        max[0] = Math.max(max[0], left + right + 1);
        return left + right + 1;
    }
    private int findMax(TreeNode root){
        int result = root.key;
        while(root.right != null){
            root = root.right;
            result = root.key;
        }
        return result;
    }
    private int findMin(TreeNode root){
        int result = root.key;
        while(root.left != null){
            root = root.left;
            result = root.key;
        }
        return result;
    }
}
