package Tree;

import java.util.*;

public class VerticalListOfBinaryTree {
    // Given a binary tree, get the vertically representation of it as a list of lists.
    //
    //The columns should be from left to right, and for each column the nodes should be placed from top to bottom,
    // from left to right.

    public List<List<Integer>> verticalPrint(TreeNode root) {
        // 用map存，算的最简单
        List<List<Integer>> result = new ArrayList<>();
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
        for (Object o : key) {
            result.add(map.get(o));
        }


        return result;
    }

    public List<List<Integer>> anotherWay(TreeNode root) {
        // 用两个数据结构存，不太好，浪费空间
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<MyPair> queue = new ArrayDeque<>();
        Deque<List<Integer>> left = new ArrayDeque<>();
        Queue<List<Integer>> right = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(new MyPair(root, 0));
        while(! queue.isEmpty()){
            MyPair pair = queue.poll();
            if(pair.column < 0){
                int num = Math.abs(pair.column);
                if(num > left.size()){
                    List<Integer> tmp = new ArrayList<>();
                    map.put(pair.column, tmp);
                    tmp.add(pair.node.key);
                    left.offerFirst(tmp);
                }
                else{
                    List<Integer> tmp = map.get(pair.column);
                    tmp.add(pair.node.key);
                }
            }
            else if(pair.column == 0){
                list.add(pair.node.key);
            }
            else{
                if(pair.column > right.size()){
                    List<Integer> tmp = new ArrayList<>();
                    map.put(pair.column, tmp);
                    tmp.add(pair.node.key);
                    right.offer(tmp);
                }
                else{
                    List<Integer> tmp = map.get(pair.column);
                    tmp.add(pair.node.key);
                }
            }
            if(pair.node.left != null){
                queue.offer(new MyPair(pair.node.left, pair.column - 1));
            }
            if(pair.node.right != null){
                queue.offer(new MyPair(pair.node.right, pair.column + 1));
            }
        }

        while(! left.isEmpty()){
            result.add(left.pollFirst());
        }
        result.add(list);
        while(! right.isEmpty()){
            result.add(right.poll());
        }

        return result;
    }
}


