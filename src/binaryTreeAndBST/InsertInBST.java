package binaryTreeAndBST;

public class InsertInBST {
    public TreeNode insert(TreeNode root, int key){
        TreeNode node = new TreeNode(key);
        if(root == null){
            return node;
        }
        TreeNode prev = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.key < key){
                prev = cur;
                cur = cur.right;
            }
            else if(cur.key > key){
                prev = cur;
                cur = cur.left;
            }
            else{
                return root;
            }
        }

        if(prev.key < key){
            prev.right = node;
        }
        else{
            prev.left = node;
        }

        return root;
    }

    public TreeNode recursionWay(TreeNode root, int key){
        TreeNode node = new TreeNode(key);
        return recursion(root, node);
    }
    private TreeNode recursion(TreeNode root, TreeNode node){
        if(root == null){
            return node;
        }

        if(root.key == node.key){
            return root;
        }

        if(root.key < node.key){
            root.right = recursion(root.right, node);
        }
        if(root.key > node.key){
            root.left = recursion(root.left, node);
        }

        return root;
    }

}
