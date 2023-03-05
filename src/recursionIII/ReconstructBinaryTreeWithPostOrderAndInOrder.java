package recursionIII;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostOrderAndInOrder {
    public TreeNode reConstruct(int[] inOrder, int[] postOrder){
        //assume not null
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }

        return findAll(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, map);
    }
    private TreeNode findAll(int[] inOrder, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight, Map<Integer, Integer> map){
        if(inLeft > inRight){
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postRight]);
        int leftSize = map.get(root.val);

        root.left = findAll(inOrder, inLeft, inLeft + leftSize - 1, postOrder, postLeft, postLeft + leftSize - 1, map);
        root.right = findAll(inOrder,inLeft + leftSize + 1, inRight, postOrder, postLeft + leftSize, postRight - 1, map);

        return root;
    }
}
