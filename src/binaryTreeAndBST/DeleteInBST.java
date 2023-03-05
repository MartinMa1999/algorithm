package binaryTreeAndBST;

public class DeleteInBST {
    public TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }

        if(root.key < key){
            root.right = delete(root.right, key);
        }
        else if(root.key > key){
            root.left = delete(root.left, key);
        }
        else{
            if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }

            if(root.right.left == null){
                root.right.left = root.left;
                return root.right;
            }
            else{
                TreeNode smallNode = findSmall(root);
                smallNode.left = root.left;
                smallNode.right = root.right;
                return smallNode;
            }
        }
        return root;
    }
    private TreeNode findSmall(TreeNode root){
        //找右子树的最左, 把它的右子树接到上一个的左子树上
        TreeNode cur = root.right;
        TreeNode prev = null;
        while(cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        return cur;
    }

    public TreeNode IterativeWay(TreeNode root, int key){
        SearchInBST search = new SearchInBST();
        if(root == null || search.search(root, key) == null){
            return null;
        }

        TreeNode cur = root;
        TreeNode prev = cur;
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
                break;
            }
        }

        if(cur.left == null || cur.right == null){
            if(prev.key < key){
                prev.right = cur.left == null ? cur.right : cur.left;
            }
            else{
                prev.left = cur.left == null ? cur.right : cur.left;
            }
        }
        else if(cur.right.left == null){
            cur.right.left = cur.left;
            if(prev.key < key){
                prev.right = cur.right;
            }
            else{
                prev.left = cur.left;
            }
        }
        else{
            TreeNode smallNode = findSmall(cur);
            smallNode.left = cur.left;
            smallNode.right = cur.right;
            if(prev.key < key){
                prev.right = smallNode;
            }
            else{
                prev.left = smallNode;
            }
        }

        return root;
    }
}
