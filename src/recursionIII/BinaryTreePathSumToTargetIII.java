package recursionIII;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreePathSumToTargetIII {
    //Determine if there exists a path (the path can only be from one node to itself or to any of its descendants),
    // the sum of the numbers on the path is the given target number.
    //大概意思就是不能拐弯

    public boolean exist(TreeNode root, int target){
        if(root == null){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return findAll(root, target, set, 0);
    }

    private boolean findAll(TreeNode root, int target, Set<Integer> set, int prefix){
        if(root == null){
            return false;
        }

        prefix += root.val;

        if(set.contains(prefix - target)){
            return true;
        }

        boolean tmp = set.add(prefix);

        if(findAll(root.left, target, set, prefix) || findAll(root.right, target, set, prefix)){
            return true;
        }

        if(tmp){//吃吐平衡
            set.remove(prefix);
        }

        return false;
    }
}
