package MorrisTraversal;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    List<Node> children = new ArrayList<>();
    Node(int val){ // 其中所有children的排列都是按照从左到右的顺序排列好的
        this.val = val;
    }

}
