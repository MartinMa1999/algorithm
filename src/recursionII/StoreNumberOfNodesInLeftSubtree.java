package recursionII;

public class StoreNumberOfNodesInLeftSubtree {
    public void numNodesLeft(TreeNodeLeft root){
        countNode(root);
    }
    public int countNode(TreeNodeLeft root){
        if(root == null){
            return 0;
        }

        int left = countNode(root.left);
        int right = countNode(root.right);
        root.numNodesLeft = left;

        return left + right + 1;
    }
}

class TreeNodeLeft {
   public int key;
   public TreeNodeLeft left;
   public TreeNodeLeft right;
   public int numNodesLeft;
   public TreeNodeLeft(int key) {
     this.key = key;
   }
}
