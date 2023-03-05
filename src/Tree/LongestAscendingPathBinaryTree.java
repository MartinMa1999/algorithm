package Tree;

public class LongestAscendingPathBinaryTree {
    // Determine the length of the longest ascending path in the binary tree.
    //
    //A valid path is a part of the path from root to any of the leaf nodes.

    public int longest(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] longest = new int[1];
        findAll(root, longest, Integer.MIN_VALUE, 0);
        return longest[0];
    }
    private void findAll(TreeNode root, int[] longest, int lastKey, int length){
        if(root == null){
            longest[0] = Math.max(longest[0], length); // bug !! 此时走完了必须判断长度
            return;
        }

        if(root.key > lastKey){
            length++;
        }
        else{
            longest[0] = Math.max(longest[0], length);
            length = 1;
        }

        findAll(root.left, longest, root.key, length);
        findAll(root.right, longest, root.key, length);


    }
}
