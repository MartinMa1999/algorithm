package Tree;

import java.util.*;

public class TopViewOfBinaryTree {
    // Given a binary tree, get the top view of it. The nodes in the output list should be from left to right.
    // A node x belongs to the output if x is the topmost node at its column.

    public List<Integer> topView(TreeNode root) {
        // dfs
        // 如果第一次见更左边的就把他加进去，重复的不看；如果重复看到了右边的就要更新右边的。因为是preorder从左到右，所以肯定先能把左边的走完了，左边
        // 延申到右边的可以通过后面走右边的时候给覆盖了，就是最上面的
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        findAll(root, stack, list, 0);

        while(! stack.isEmpty()){
            result.add(stack.pollFirst());
        }
        result.add(root.key);
        result.addAll(list);
        return result;

    }
    private void findAll(TreeNode root, Deque<Integer> stack, List<Integer> list, int column){
        if(root == null){
            return;
        }

        if(column < 0){
            if(stack.size() < Math.abs(column)){
                stack.offerFirst(root.key);
            }

        }
        else if (column > 0){
            if(list.size() < column){
                list.add(root.key);
            }
            else{
                list.set(column - 1, root.key);
            }
        }

        findAll(root.left, stack, list, column - 1);
        findAll(root.right, stack, list, column + 1);
    }

    public List<Integer> BFS(TreeNode root) {
        // BFS, 从上到下每次更新root和column，遇到没见过的就加进去
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<Integer> right = new ArrayDeque<>();
        Deque<Integer> left = new ArrayDeque<>();
        Queue<MyPair> queue = new ArrayDeque<>();
        queue.offer(new MyPair(root, 0));

        while(! queue.isEmpty()){
            MyPair tmp = queue.poll();
            if(tmp.column < 0){
                if(Math.abs(tmp.column) > left.size()){
                    left.offerFirst(tmp.node.key);
                }
            }

            if (tmp.column > 0){
                if(tmp.column > right.size()){
                    right.offer(tmp.node.key);
                }
            }

            if(tmp.node.left != null){
                queue.offer(new MyPair(tmp.node.left, tmp.column - 1));
            }

            if(tmp.node.right != null){
                queue.offer(new MyPair(tmp.node.right, tmp.column + 1));
            }
        }

        while(! left.isEmpty()){
            result.add(left.pollFirst());
        }
        result.add(root.key);

        while(! right.isEmpty()){
            result.add(right.poll());
        }
        return result;
    }
}
class MyPair{
    TreeNode node;
    int column;
    MyPair(TreeNode node, int column){
        this.node = node;
        this.column = column;
    }
}