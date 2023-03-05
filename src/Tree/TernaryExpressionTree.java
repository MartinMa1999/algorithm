package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TernaryExpressionTree {
    // Implement a solution to parse a ternary expression into a tree.

    //见到？就连到top的左边并且把它放到stack里，见到：就把刚放进去的弹出来，然后连到top的右边，之后把top弹出来

    public ExpNode tree(String exp) {
        if(exp.length() == 0){
            return null;
        }
        ExpNode root = new ExpNode(exp.charAt(0));
        int i = 0;
        Deque<ExpNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while(i + 2 < exp.length()){
            if (exp.charAt(i + 1) == '?'){
                ExpNode newNode = new ExpNode(exp.charAt(i + 2));
                stack.peekFirst().left = newNode;
                stack.offerFirst(newNode);
                i += 2;
            }
            else if(exp.charAt(i + 1) == ':'){
                stack.pollFirst();
                ExpNode newNode = new ExpNode(exp.charAt(i + 2));
                stack.peekFirst().right = newNode;
                stack.pollFirst();
                stack.offerFirst(newNode);
                i += 2;
            }
        }

        return root;
    }
}
class ExpNode {
   public char symbol;
   public ExpNode left;
   public ExpNode right;
   public ExpNode(char symbol) {
     this.symbol = symbol;
   }
 }
