package DPTopic;

public class HouseRobberIII {
    // The thief has found himself a new place for his thievery again.
    // There is only one entrance to this area, called the "root."
    // Besides the root, each house has one and only one parent house.
    // After a tour, the smart thief realized that "all houses in this place forms a binary tree".
    // It will automatically contact the police if two directly-linked houses were broken into on the same night.

    // 不能用level order traverse，因为如果上面不选，不一定下面两个都选，所以只能用dfs返回值。且从上到下无法返回和
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] result = findAll(root);
        return Math.max(result[0], result[1]);
    }
    private int[] findAll(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = findAll(root.left);
        int[] right = findAll(root.right);
        int rob = root.key + left[1] + right[1];
        int norob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, norob};

    }

    static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
}
