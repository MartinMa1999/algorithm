package crossTrainingI;

public class LCAII {
    public TreeNodeP LCA(TreeNodeP left, TreeNodeP right){
        //assume root is not null and two nodes are in the same tree
        int height1 = getHeight(left);
        int height2 = getHeight(right);

        while(height1 > height2){
            left = left.parent;
            height1--;
        }
        while(height2 > height1){
            right = right.parent;
            height2--;
        }

        while(height1 > 0){
            if(left == right){
                return left;
            }
            left = left.parent;
            right = right.parent;
            height1--;
        }

        return null;
    }
    private int getHeight(TreeNodeP cur){
        int sum = 1;
        while(cur != null){
            cur = cur.parent;
            sum++;
        }
        return sum;
    }
}
class TreeNodeP {
  public int key;
  public TreeNodeP left;
  public TreeNodeP right;
  public TreeNodeP parent;
  public TreeNodeP(int key, TreeNodeP parent) {
      this.key = key;
      this.parent = parent;
  }
}