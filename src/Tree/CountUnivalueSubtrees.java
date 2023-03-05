package Tree;

public class CountUnivalueSubtrees {
    // Given a binary tree, count the number of uni-value subtrees.
    //
    //A Uni-value subtree means all nodes of the subtree have the same value.

    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] sum = new int[1];
        findAll(root, sum);
        return sum[0];
    }
    private boolean findAll(TreeNode root, int[] sum){
        if(root == null){
            return true;
        }

        boolean left = findAll(root.left, sum);
        boolean right = findAll(root.right, sum);
        if(! left || ! right){
            return false;
        }

        if(root.left == null && root.right == null){
            sum[0] += 1;
            return true;
        }
        else if(root.left == null){
            if(root.key == root.right.key){
                sum[0] += 1;
                return true;
            }
            else{
                return false;
            }
        }

        else if(root.right == null){
            if(root.key == root.left.key){
                sum[0] += 1;
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(root.key == root.left.key && root.key == root.right.key){
                sum[0] += 1;
                return true;
            }
        }

        return false;
    }
}
