package crossTrainingI;

import java.util.List;

public class LCAVI {
    public KnaryTreeNode LCA(KnaryTreeNode root, List<KnaryTreeNode> nodes){
        if(root == null || nodes.contains(root)){
            return root;
        }

        KnaryTreeNode result = null;
        for(KnaryTreeNode node : root.children){
            KnaryTreeNode LCA = LCA(node, nodes);
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
