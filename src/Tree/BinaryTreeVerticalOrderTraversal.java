package Tree;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    // Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
    //
    //If two nodes are in the same row and column, the order should be from left to right.

    public List<Integer> verticalOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<MyPair> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        queue.offer(new MyPair(root, 0));
        while(! queue.isEmpty()){
            MyPair pair = queue.poll();
            if(! map.containsKey(pair.column)){
                List<Integer> tmp = new ArrayList<>();
                map.put(pair.column, tmp);
            }
            map.get(pair.column).add(pair.node.key);
            if(pair.node.left != null){
                queue.offer(new MyPair(pair.node.left, pair.column - 1));
            }
            if(pair.node.right != null){
                queue.offer(new MyPair(pair.node.right, pair.column + 1));
            }
        }

        Object[] key = map.keySet().toArray();
        Arrays.sort(key);
        for(Object o : key){
            for(int i : map.get(o)){
                result.add(i);
            }
        }
        return result;
    }
}
