package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // Given an array of integers, find if the array contains any duplicates. Your function should return true
    // if any value appears at least twice in the array, and it should return false if every element is distinct.

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
