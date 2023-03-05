package Tree;

public class ConvertBinaryTreeToDoublyLinkedListI{
    // Given a binary tree, convert it to a doubly linked list in place (use the left pointer as previous,
    // use the right pointer as next).
    //
    //The values in the nodes of the doubly linked list should follow the in-order traversal sequence of the binary tree.


    //见到inorder就用inorder的recursion方法来解决问题
    public TreeNode toDoubleLinkedList(TreeNode root) {
        if(root == null){
            return root;
        }

        return traverseAll(root);
    }

    private TreeNode traverseAll(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode head = traverseAll(root.left);
        TreeNode tmp = head;
        if(head != null){
            while(tmp.right != null){
                tmp = tmp.right;
            }
            tmp.right = root;
            root.left = tmp; // 必须要更新左侧
        }
        else{
            head = root;
        }
        TreeNode right = traverseAll(root.right);
        if(right != null){
            right.left = root;
        }
        root.right = right;

        return head;
    }

    // better way
    public TreeNode better(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode[] prev = new TreeNode[1];
        return traverseAll(root, prev);
    }

    private TreeNode traverseAll(TreeNode root, TreeNode[] prev){
        if(root.left == null){
            if(prev[0] != null){
                prev[0].right = root;
                root.left = prev[0];
            }
            prev[0] = root;
            if(root.right != null){
                traverseAll(root.right, prev);
            }
            return root;
        }

        TreeNode sub = traverseAll(root.left, prev);
        prev[0].right = root;
        root.left = prev[0];
        prev[0] = root;

        if(root.right != null){
            traverseAll(root.right, prev);
        }

        return sub;

    }
}
