package binaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBST {
    public List<Integer> getKeys(TreeNode root, int min, int max){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        getKeys(root, min, max, result);
        return result;
    }
    private void getKeys(TreeNode root, int min, int max, List<Integer> result){
        if(root == null){
            return;
        }
        //先找左边界，然后找到左边界之后放到result里面，然后再找右边界
        if(root.key > min){
            getKeys(root.left, min, max, result);
        }

        if(root.key >= min && root.key <= max){
            result.add(root.key);
        }

        if(root.key < max){
            getKeys(root.right, min, max, result);
        }
    }
}
