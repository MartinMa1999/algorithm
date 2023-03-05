package Tree;

public class DistanceOfTwoNodesInBinaryTree {
    // Find distance between two given keys of a Binary Tree, no parent pointers are given.
    // Distance between two nodes is the minimum number of edges to be traversed to reach one node from another.

    // 先找到两个点，然后直接往回返，按照找LCA的方法，如果LCA不是他们自己，就在找到LCA之后直接return LCA，如果是，就必须在base case判断是否已经找到LCA，如果没有就要给
    // 路径长度加1，如果有的话就直接返回此时的root。这样可以两次遍历解决问题
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(13);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(101);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(10);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node5.left = node9;
        node5.right = node10;

        DistanceOfTwoNodesInBinaryTree test = new DistanceOfTwoNodesInBinaryTree();
        test.distance(node1, 8, 9);
    }

    public int distance(TreeNode root, int k1, int k2) {
        if(root == null){
            return 0;
        }
        TreeNode node1 = findIt(root, k1);
        TreeNode node2 = findIt(root, k2);

        int[] sum = new int[1];
        boolean[] LCA = new boolean[1];
        findDistance(root, node1, node2, sum, LCA);
        return sum[0];
    }

    private TreeNode findIt(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.key == val){
            return root;
        }

        if(findIt(root.left, val) != null){
            return findIt(root.left, val);
        }
        if(findIt(root.right, val) != null){
            return findIt(root.right, val);
        }

        return null;
    }

    private TreeNode findDistance(TreeNode root, TreeNode node1, TreeNode node2, int[] sum, boolean[] LCA){
        if(root == null){
            return root;
        }

        TreeNode left = findDistance(root.left, node1, node2, sum, LCA);
        TreeNode right = findDistance(root.right, node1, node2, sum, LCA);

        if(root == node1){
            if(! LCA[0]){
                if(left == null && right == null){
                    sum[0] += 1;
                }
                else{
                    LCA[0] = true;
                }
            }
            return root;
        }

        if(root == node2){
            if(! LCA[0]){
                if(left == null && right == null){
                    sum[0] += 1;
                }
                else{
                    LCA[0] = true;
                }
            }
            return root;
        }

        if(left != null && right != null){
            return root;
        }

        if(left == null){
            if(right == node1 || right == node2){
                if(! LCA[0]){ // bug！！如果此时返回的是已经到lca之后的状态，就不能加sum了
                    sum[0] += 1;
                }

            }
            return right;
        }

        if(left == node1 || left == node2){
            if(! LCA[0]) {
                sum[0] += 1;
            }
        }
        return left;



    }
}
