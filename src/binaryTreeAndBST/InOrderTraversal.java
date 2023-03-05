package binaryTreeAndBST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversal {
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

        recursion(root.left, result);
        result.add(root.key);
        recursion(root.right, result);
    }

    public List<Integer> iterativeWay(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;

        while(helper != null || ! stack.isEmpty()){
            if(helper != null){
                stack.offerFirst(helper);
                helper = helper.left;
            }
            else{
                TreeNode tmp = stack.pollFirst();
                result.add(tmp.key);
                helper = tmp.right;
            }
        }

        return result;

    }
}
