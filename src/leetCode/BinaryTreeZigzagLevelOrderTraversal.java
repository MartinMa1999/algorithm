package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    // leetcode 103
    // 如果不用deque，使用一个queue也可以解决，只不过每次输出的时候都需要重新根据当前的层数调整输出顺序
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 1;
        while(! queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                list1.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }

            if(count % 2 == 0){
                List<Integer> list2 = new ArrayList<>();
                for(int i = list1.size() - 1; i >= 0; i--){
                    list2.add(list1.get(i));
                }
                result.add(list2);
            }
            else{
                result.add(list1);
            }

            count++;
        }

        return result;
    }

    public List<List<Integer>> betterWay(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isInverted = false;
        while(! queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if(! isInverted){
                    list.add(node.val);
                }
                else{
                    list.add(0, node.val);
                }
                size--;
            }

            isInverted = !isInverted;
        }

        return result;
    }
}
