package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // Given a binary tree, return all root-to-leaf paths from left to right.

    public String[] binaryTreePaths(TreeNode root) {
        if(root == null){
            return new String[0];
        }

        List<String> list = new ArrayList<>();
        findAll(root, list, new StringBuilder());

        return list.toArray(new String[0]);
    }

    private void findAll(TreeNode root, List<String> list, StringBuilder sb){
        if(root.left == null && root.right == null){
            int num = root.key;
            List<Integer> tmp = new ArrayList<>();
            if(num == 0){
                tmp.add(0);
            }
            while(num != 0){
                tmp.add(num % 10);
                num /= 10;
            }
            int size = tmp.size();
            for(int i = size - 1; i >= 0; i--){
                sb.append((char) (tmp.get(i) + '0'));
            }
            list.add(sb.toString());
            for(int i = size - 1; i >= 0; i--){
                sb.deleteCharAt(sb.length() - 1);
            }

            return;
        }


        int num = root.key;
        List<Integer> tmp = new ArrayList<>();
        if(num == 0){ // 注意如果数字为0，下面的就跑不通
            tmp.add(0);
        }
        while(num != 0){ // 如果数字大于10就需要分开算
            tmp.add(num % 10);
            num /= 10;
        }
        int size = tmp.size();
        for(int i = size - 1; i >= 0; i--){
            sb.append((char) (tmp.get(i) + '0'));
        }
        sb.append('-');
        sb.append('>');
        if(root.left != null){
            findAll(root.left, list, sb);
        }
        if(root.right != null){
            findAll(root.right, list, sb);
        }

        for(int i = 0; i < size + 2; i++){
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
