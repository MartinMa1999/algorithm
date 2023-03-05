package crossTrainingI;

import java.util.*;

public class ClosetNumberInBSTII {
    //sliding window
    public int[] closetK(TreeNode root, int target, int k){
        // assume input cannot be null
        int[] result = new int[k];
        Queue<Integer> queue = new ArrayDeque<>();
        findAll(root, target, k, queue);
        int i = 0;
        while(! queue.isEmpty()){
            result[i++] = queue.poll();
        }
        if(i < k){
            return Arrays.copyOf(result, i);
        }
        return result;
    }
    private void findAll(TreeNode root, int target, int k, Queue<Integer> queue){
        //本质上就是in order traversal，走到最左边然后放到sliding window里面
        if(root == null){
            return;
        }

        findAll(root.left, target, k, queue);

        if(queue.size() < k){
            queue.offer(root.key);
        }
        else{
            if(Math.abs(queue.peek() - target) > Math.abs(root.key - target)){
                queue.poll();
                queue.offer(root.key);
            }
            else{
                return;
            }
        }
        findAll(root.right, target, k, queue);
    }

    public int[] closestKValues(TreeNode root, double target, int k) {
        if(k < 0 || root == null) {
            return null;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || ! stack.isEmpty()){
            if(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pollFirst();
                if(k > 0){
                    queue.offer(cur.key);
                    k--;
                }
                else{
                    if(Math.abs(queue.peek() - target) > Math.abs(cur.key - target)){
                        queue.poll();
                        queue.offer(cur.key);
                    }
                    else{
                        break;
                    }
                }
                cur = cur.right;
            }
        }

        List<Integer> list = new ArrayList<>();
        while(! queue.isEmpty()){
            list.add(queue.poll());
        }

        Integer[] tmp = list.toArray(new Integer[0]);
        int[] result = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++){
            result[i] = tmp[i];
        }
        return result;
    }
}
