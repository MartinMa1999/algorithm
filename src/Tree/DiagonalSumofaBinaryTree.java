package Tree;

import java.util.*;

public class DiagonalSumofaBinaryTree {
    // Diagonal sum in a binary tree is the sum of all the node’s data lying through the dashed lines.
    // Given a Binary Tree, print all diagonal sums.

    // 大概想法就是根据每一个对角线上元素的level - column来分类，都存到map里面

    public List<Integer> diagonalSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Element> queue = new ArrayDeque<>();
        queue.offer(new Element(0, 0, root));
        while(! queue.isEmpty()){
            Element tmp = queue.poll();
            if(! map.containsKey(tmp.level - tmp.col)){
                map.put(tmp.level - tmp.col, 0);
            }
            map.put(tmp.level - tmp.col, map.get(tmp.level - tmp.col) + tmp.node.key);

            if(tmp.node.left != null){
                queue.offer(new Element(tmp.col - 1, tmp.level + 1, tmp.node.left));
            }

            if(tmp.node.right != null){
                queue.offer(new Element(tmp.col + 1, tmp.level + 1, tmp.node.right));
            }
        }

        Object[] key = map.keySet().toArray();
        Arrays.sort(key);
        for(Object o : key){
            result.add(map.get(o));
        }
        return result;
    }
}

class Element{
    int col;
    int level;
    TreeNode node;
    Element(int col, int level, TreeNode node){
        this.col = col;
        this.level = level;
        this.node = node;
    }
}

