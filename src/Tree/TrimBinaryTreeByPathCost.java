package Tree;

import java.util.TreeMap;

public class TrimBinaryTreeByPathCost {
    // Given a binary tree, the path cost from the root node to each leaf node is defined to be the number of levels that
    // the leaf is on.
    //
    //For example, in the following binary tree, the node 5 has its path cost to be 3, and node 8 has its path cost to be 4.

    // Given a binary tree, try to delete all the nodes that have no paths whose cost is >= k that go through it.
    static TreeNode root = new TreeNode(1);
    public static void main(String[] args) {
        TrimBinaryTreeByPathCost test = new TrimBinaryTreeByPathCost();

        test.trimTree(root, 2);
    }
    public TreeNode trimTree(TreeNode root, int k) {
        if(k <= 1 || root == null){
            return root;
        }

        findAll(root, k, 1, null);
        if(root.left == null && root.right == null){
            return null;
        }
        return root;
    }
    private void findAll(TreeNode root, int k, int cost, TreeNode prev){
        if(cost == k){
            return;
        }
        if(root == null){
            return;
        }

        findAll(root.left, k, cost + 1, root);
        findAll(root.right, k, cost + 1, root);

        if(root.left == null && root.right == null && cost < k){
            if(prev != null){
                if(root == prev.left){
                    prev.left = null;
                }
                else{
                    prev.right = null;
                }
            }
            else{
                root = null; // bug!!这样只改了这个指针的指向，而没有改值
            }

        }
    }
}
