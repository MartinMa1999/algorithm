package binaryTreeAndBST;

public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null || node1.key != node2.key){
            return false;
        }

        return isTweakedIdentical(node1.left, node2.right) && isTweakedIdentical(node1.right, node2.left) || isTweakedIdentical(node1.left, node2.left) && isTweakedIdentical(node1.right, node2.right);
    }
}
