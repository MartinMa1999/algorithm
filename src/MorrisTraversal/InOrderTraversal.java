package MorrisTraversal;


import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(20);
        TreeNode node2 = new TreeNode(30);
        TreeNode node3 = new TreeNode(40);
        TreeNode node4 = new TreeNode(50);
        TreeNode node5 = new TreeNode(60);
        TreeNode node6 = new TreeNode(70);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrderTraversal(root);
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode bridgeNode = findIt(cur, cur.left);
                if(bridgeNode.right == null){
                    bridgeNode.right = cur;
                    cur = cur.left;
                }
                else {
                    bridgeNode.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
            else{
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }
    private TreeNode findIt(TreeNode root, TreeNode node){
        while(node.right != null && node.right != root){ // bug!因为node如果之前已经连接过root了，那么就没办法停下来
            node = node.right;
        }
        return node;
    }
}
