package Tree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    // Given a Binary Tree, return the right view of it. Right view of a Binary Tree is list of nodes visible
    // when tree is visited from Right side, the order of the nodes in the list should be from top to bottom level
    // of the original tree.

    public List<Integer> rightView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        findAll(root, 0, result);
        return result;
    }

    private void findAll(TreeNode root, int index, List<Integer> result){
        if(result.size() == index){
            result.add(root.key);
        }
        if(root.right != null){
            findAll(root.right, index + 1, result);
        }
        if(root.left != null){
            findAll(root.left, index + 1, result);
        }

    }
}
