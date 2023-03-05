package Tree;

public class BinaryTreeLongestConsecutiveSequence {
    // Given a binary tree, find the length of the longest consecutive sequence path.
    //
    //The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
    // The longest consecutive path need to be from parent to child (cannot be the reverse).

    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] max = new int[]{1};
        findAll(root, max);
        return max[0];
    }
    private int findAll(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = findAll(root.left, max);
        int right = findAll(root.right, max);

        if(left == 0 && right == 0){
            return 1;
        }

        int tmp = 1;

        if(left != 0){
            if(root.key - root.left.key == -1){
                tmp = left + 1;
            }
        }

        if(right != 0){
            if(root.key - root.right.key == -1){
                tmp = Math.max(tmp, right + 1);
            }
        }

        max[0] = Math.max(max[0], tmp);
        return tmp;
    }
}
