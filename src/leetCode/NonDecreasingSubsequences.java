package leetCode;

import java.util.*;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        NonDecreasingSubsequences nonDecreasingSubsequences = new NonDecreasingSubsequences();
        nonDecreasingSubsequences.findSubsequencesOfficial(new int[]{7,8,7,8});
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length <= 1){
            return result;
        }
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            findAll(nums, i + 1, list, result, set);

            list.remove(list.size() - 1);
        }

        return result;
    }

    private void findAll(int[] nums, int index, List<Integer> list, List<List<Integer>> result, Set<List<Integer>> set){
        if(index == nums.length){
            if(list.size() > 1 && set.add(new ArrayList<>(list))){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(nums[index] >= list.get(list.size() - 1)){
            list.add(nums[index]);
            findAll(nums, index + 1, list, result, set);
            list.remove(list.size() - 1);
        }

        findAll(nums, index + 1, list, result, set);
    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequencesOfficial(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) { // 因为每次都要走到结尾才能停下，所以按照规则，比如存在7878，第一个78一定不会output，而会等到第二个8加进来走完之后才会输出
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
