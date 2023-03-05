package crossTrainingI;

import java.util.ArrayList;
import java.util.List;

public class LCAV {
    public KnaryTreeNode LCA(KnaryTreeNode root, KnaryTreeNode one, KnaryTreeNode two){
        if(root == null || root == one || root == two){
            return root;
        }

        KnaryTreeNode result = null;
        for(KnaryTreeNode node : root.children){
            KnaryTreeNode LCA = LCA(node, one, two);
            if(LCA != null){
                if(result == null){
                    result = LCA;
                }
                else{
                    result = root;
                }
            }
        }
        return result;



    }
}
class KnaryTreeNode {
    int key;
    List<KnaryTreeNode> children;
    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}