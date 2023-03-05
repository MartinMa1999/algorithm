package binaryTreeAndBST;

public class isBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        这种直接比较值的方法，需要一个set存所有见过的元素，否则可能同一个元素多次出现。TC = O(n), SC = O(n)
//        if(root == null){
//            return true;
//        }
//        if(root.left == null && root.right == null){
//            return true;
//        }
//
//
//        if(root.left != null && root.left.key >= root.key || root.right != null && root.right.key < root.key){
//            return false;
//        }
//
//        return isBST(root.left) && isBST(root.right);
    }
    private boolean isBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.key < min || root.key > max){
            return false;
        }

        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }
}
