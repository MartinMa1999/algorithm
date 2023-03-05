package Tree;

import java.util.HashMap;
import java.util.Map;

public class GetPostorderSequenceByPreorderandInorder {
    // Given Inorder and Preorder traversals of a binary tree, get the Postorder traversal without reconstructing a binary tree.

    public static void main(String[] args) {
        GetPostorderSequenceByPreorderandInorder test = new GetPostorderSequenceByPreorderandInorder();
        int[] a = new int[]{2,4,3,5};
        int[] b = new int[]{2,3,4,5};
        test.postOrder(a, b);
    }

    public int[] postOrder(int[] preorder, int[] inorder) {
        int[] result = new int[preorder.length];
        int[] index = new int[]{result.length - 1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        findAll(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, result, index);
        return result;
    }
    private void findAll(Map<Integer, Integer> map, int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright, int[] result, int[] index){
        if(preleft > preright){ // bug !!如果出现这种情况说明已经走完了
            return;
        }

        int tmp = index[0];
        result[tmp] = preorder[preleft];
        index[0]--;
        int leftSize = map.get(preorder[preleft]) - inleft;

        findAll(map, preorder, preleft + leftSize + 1, preright, inorder, inleft + leftSize + 1, inright, result, index);
        findAll(map, preorder, preleft + 1, preleft + leftSize, inorder, inleft, inleft + leftSize - 1, result, index);

    }
}
