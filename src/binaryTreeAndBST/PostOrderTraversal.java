package binaryTreeAndBST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> recursiveWay(TreeNode root){
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
        recursion(root.right, result);
        result.add(root.key);
    }

    public List<Integer> iterativeWay(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;
        stack.offerFirst(root);

        while(! stack.isEmpty()){
            cur = stack.peekFirst();//注意每一轮的cur都是stack头上的部分
            if(prev == null || cur == prev.left || cur == prev.right){
                if(cur.left != null){
                    stack.offerFirst(cur.left);
                }
                else if(cur.right != null){
                    stack.offerFirst(cur.right);
                }
                else{
                    result.add(cur.key);
                    stack.pollFirst();
                }
            }
            else if(prev == cur.left){
                if(cur.right != null){
                    stack.offerFirst(cur.right);
                }
                else{
                    result.add(cur.key);
                    stack.pollFirst();
                }
            }
            else{
                result.add(cur.key);
                stack.pollFirst();
            }
            prev = cur;
        }
        return result;
    }
}
