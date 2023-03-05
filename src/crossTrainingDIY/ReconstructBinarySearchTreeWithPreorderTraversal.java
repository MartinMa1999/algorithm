package crossTrainingDIY;

public class ReconstructBinarySearchTreeWithPreorderTraversal {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 8, 5, 4, 7, 12, 10, 13};
        ReconstructBinarySearchTreeWithPreorderTraversal test = new ReconstructBinarySearchTreeWithPreorderTraversal();
        test.reconstruct(array);

    }

    public TreeNode reconstruct(int[] pre) {
        return findAll(pre, 0, pre.length - 1);
    }

    private TreeNode findAll(int[] pre, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[left]);
        if (pre[right] < root.key) {
            root.right = null;
            root.left = findAll(pre, left + 1, right);
        } else {
            int count = 0;
            for (int i = left + 1; i <= right; i++) {// 可以用binary search优化
                if (pre[i] < root.key) {
                    count++;
                } else {
                    break;
                }
            }
            root.left = findAll(pre, left + 1, left + count);
            root.right = findAll(pre, left + count + 1, right);
        }

        return root;
    }
}
