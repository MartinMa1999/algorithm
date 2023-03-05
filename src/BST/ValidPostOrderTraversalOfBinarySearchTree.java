package BST;

import java.util.ArrayList;
import java.util.List;

public class ValidPostOrderTraversalOfBinarySearchTree {
    // Given an array with integers, determine whether the array contains a valid postorder traversal sequence a BST.

    //如果是左右根，就会有一个点，左边的都比根小，右边的都比根大。如果存在这个点就是valid，如果不存在就是invalid
    public boolean validPostOrder(int[] post) {
        if(post.length == 0){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        for(int i : post){
            list.add(i);
        }
        return isValid(list);
    }
    private boolean isValid(List<Integer> list){
        if(list.size() <= 1){
            return true;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int mid = findMid(list);
        if(mid == -1){
            return false;
        }

        for(int i = 0; i <= mid; i++){
            left.add(list.get(i));
        }
        for(int i = mid + 1; i < list.size() - 1; i++){
            right.add(list.get(i));
        }

        return isValid(left) && isValid(right);
    }
    private int findMid(List<Integer> list){
        int mid = list.size() - 2; // 假设所有的都在左边，如果所有的都在右边，则不会出bug，但是不能得到正确的树
        int tmp = list.get(list.size() - 1);
        boolean visited = false;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > tmp){
                visited = true;
                mid = i - 1;
            }
            if(list.get(i) <= tmp && visited){
                return -1;
            }
        }

        return mid;
    }
}
