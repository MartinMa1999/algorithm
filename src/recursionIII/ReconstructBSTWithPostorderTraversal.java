package recursionIII;

public class ReconstructBSTWithPostorderTraversal {
    public TreeNode reConstruct(int[] postOrder){
        //assume input array cannot be null and length > 0
        return findAll(postOrder, 0, postOrder.length - 1);
    }
    private TreeNode findAll(int[] postOrder, int left ,int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(postOrder[right]);
        if(postOrder[left] > root.val){
            root.left = null;
            root.right = Method2(postOrder, left, right - 1);
        }
        else{
            int tmp = 0;//比root小的元素个数
            for (int j : postOrder) {//可以优化成用binary search找index
                if (j < tmp) {
                    tmp++;
                }
                else{
                    break;
                }
            }
            root.left = findAll(postOrder, left, left + tmp - 1);
            root.right = findAll(postOrder, left + tmp, right - 1);
        }
        return root;
    }

    private TreeNode Method2(int[] postOrder, int left ,int right){
        if(left > right){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[right]);

        if(postOrder[left] > root.val){
            root.left = null;
            root.right = Method2(postOrder, left, right - 1);
        }
        else{
            int mid = findTarget(postOrder, left, right, postOrder[right]);// first element larger than target
            root.left = Method2(postOrder, left, mid - 1);
            root.right = Method2(postOrder, mid, right - 1);
        }
        return root;
    }

    private int findTarget(int[] postOrder, int left, int right, int target){
        if(left == right){
            return left;
        }

        int result = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(postOrder[mid] < target){
                left = mid + 1;
            }
            else{
                if(mid > 0 && postOrder[mid - 1] < target){//上面已经判断过如果左子树为空的情况，所以其实走到这里mid一定会大于0
                    result = mid;
                    break;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
