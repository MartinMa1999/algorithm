package leetCode;

import java.util.TreeSet;

public class MinimizeDeviationInArray {
    // leetcode 1675
    public int minimumDeviation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i : nums){
            set.add(i % 2 == 0 ? i : i * 2);
        }

        int result = set.last() - set.first();
        while(set.last() % 2 == 0 && result > 0){
            int largest = set.last();
            set.remove(largest);
            set.add(largest / 2);
            result = Math.min(result, set.last() - set.first());
        }

        return result;
    }
}
