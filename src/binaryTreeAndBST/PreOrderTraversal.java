package binaryTreeAndBST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> recursionWay(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        recursion(root, result);
        return result;
    }
    private void recursion(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.key);
        recursion(root.left, result);
        recursion(root.right, result);
    }

    public List<Integer> iterativeWay(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(! stack.isEmpty()){
            TreeNode tmp = stack.pollFirst();
            result.add(tmp.key);
            if(tmp.right != null){
                stack.offerFirst(tmp.right);
            }
            if(tmp.left != null){
                stack.offerFirst(tmp.left);
            }
        }

        return result;
    }
}
