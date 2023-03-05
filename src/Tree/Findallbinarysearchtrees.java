package Tree;

import java.util.ArrayList;
import java.util.List;

public class Findallbinarysearchtrees {
    // Description: Given a number n, generate all possible BST from 1…n.

    // 大概逻辑是从下往上反值，然后根据边界情况生成所有的node
    public List<TreeNode> generateBSTs(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n <= 0){
            result.add(null);
            return result;
        }

        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);// bug!!!，必须加null，因为node要连，且必须保证遍历的for loop能执行，所以必须要有东西
            return result;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
