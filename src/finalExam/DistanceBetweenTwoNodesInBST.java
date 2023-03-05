package finalExam;

public class DistanceBetweenTwoNodesInBST {
    public int distance(TreeNode root, TreeNode one, TreeNode two){
        // assume this two nodes are in the same tree
        TreeNode newRoot = LCA(root, one, two);
        int distance1 = getDistance(newRoot, one);
        int distance2 = getDistance(newRoot, two);
        return distance1 + distance2;
    }
    private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
        if(root == one || root == two){
            return root;
        }
        int max = Math.max(one.val, two.val);
        int min = Math.min(one.val, two.val);

        while(root != null){
            if(root.val < min){
                root = root.right;
            }
            else if (root.val > max) {
                root = root.left;
            }
            else{
                break;
            }
        }
        return root;
    }

    private int getDistance(TreeNode root, TreeNode node){
        int count = 0;
        while(root != null){
            if(root.val < node.val){
                root = root.right;
                count++;
            }
            else if(root.val > node.val){
                root = root.left;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
    //TC = O (height), SC = O(1)
}



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }

}