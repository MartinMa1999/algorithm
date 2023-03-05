package recursionIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reConstruct(int[] level, int[] inOrder){
        //assume all input array cannot be null and no duplicate keys

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }

        List<Integer> levelOrder = new ArrayList<>();
        for(int num : level){
            levelOrder.add(num);
        }

        return findAll(levelOrder, map);
    }
    private TreeNode findAll(List<Integer> levelOrder, Map<Integer, Integer> map){
        if(levelOrder.isEmpty()){
            return null;
        }

        TreeNode root = new TreeNode(levelOrder.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int nums : levelOrder){
            if(map.get(nums) < map.get(root.val)){
                left.add(nums);
            }
            else{
                right.add(nums);
            }
        }

        root.left = findAll(left, map);
        root.right = findAll(right, map);

        return root;
    }
}
