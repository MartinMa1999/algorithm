package leetCode;

public class MinimumDistanceBetweenBSTNodes {
    // leetcode 783
    // Given the root of a Binary Search Tree (BST),
    // return the minimum difference between the values of any two different nodes in the tree.
    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes minimumDistanceBetweenBSTNodes = new MinimumDistanceBetweenBSTNodes();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

        minimumDistanceBetweenBSTNodes.minDiffInBST(node1);
    }
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int prev = -1;
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode node = findIt(cur, cur.left);
                if(node.right == null){
                    node.right = cur;
                    cur = cur.left;
                }
                else{
                    node.right = null;
                    result = Math.min(result, cur.val - prev);
                    prev = cur.val;
                    cur = cur.right;
                }
            }
            else{
                if(prev != -1){
                    result = Math.min(result, cur.val - prev);
                }
                prev = cur.val;
                cur = cur.right;
            }
        }

        return result;
    }

    private TreeNode findIt(TreeNode root, TreeNode node){
        while(node.right != null  && node.right != root){
            node = node.right;
        }
        return node;
    }
}


