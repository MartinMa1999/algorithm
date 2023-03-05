package crossTrainingDIY;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBinarySearchTreeWithLevelorderTraversal {
    public TreeNode reconstruct(int[] level) {
        List<Integer> list = new ArrayList<>();
        for(int i : level){
            list.add(i);
        }
        return findAll(list);
    }
    private TreeNode findAll(List<Integer> list){
        if(list.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(list.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i : list){
            if(i < root.key){
                left.add(i);
            }
            else{
                right.add(i);
            }
        }
        root.left = findAll(left);
        root.right = findAll(right);
        return root;
    }
}
