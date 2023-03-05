package recursionIII;


import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreOrderAndInOrder {
    //Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
    public TreeNode reConstruct(int[] inOrder, int[] preOrder){
        //assume all input array cannot be null and length > 0

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }

        return findAll(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }
    private TreeNode findAll(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight, Map<Integer, Integer> map){
        if(inLeft > inRight){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        int leftSize = map.get(preOrder[preLeft]) - inLeft;

        root.left = findAll(preOrder, preLeft + 1, preLeft + leftSize, inOrder, inLeft, inLeft + leftSize - 1, map);
        root.right = findAll(preOrder, preLeft + leftSize + 1, preRight, inOrder, inLeft + leftSize + 1, inRight, map);

        return root;
    }
}
