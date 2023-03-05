package Tree;

public class VerifyPreorderSerializationofaBinaryTree {
    // One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node,
    // we record the node's value. If it is a null node, we record using a sentinel value such as #.

//                 _9_
//                /   \
//               3     2
//              / \   / \
//             4   1  #  6
//            / \ / \   / \
//            # # # #   # #

    // For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
    // where # represents a null node.
    //
    //Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
    // Find an algorithm without reconstructing the tree.
    //
    //Each comma separated value in the string must be either an integer or a character '#' representing null pointer.


    // 整体维护需要多少个node才能画完这棵树。如果碰到了#就让空的node-1， 如果碰到了数字，就相当于占据了一个空node并产生了两个新的空node，所以
    // 此时place++。如果中途出现place用光，则return false；否则就看走完之后是不是所有的空都被放好了
    public boolean isValidSerialization(String preorder) {
        int place = 1;
        int i = 0;
        while(i < preorder.length()){
            if(place == 0){
                return false;
            }

            if(preorder.charAt(i) == ','){
                i++;
            }
            else if(preorder.charAt(i) == '#'){
                place--;
                i++;
            }
            else{
                while(i < preorder.length() && preorder.charAt(i) != ','){ // bug!!!数字可能 > 9
                    i++;
                }
                place++;
            }
        }
        return place == 0;
    }
}
