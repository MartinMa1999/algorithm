package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    // Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
    // such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= k || k <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length && i <= k; i++){
            if(! set.add(nums[i])){
                return true;
            }
        }
        for(int i = k + 1; i < nums.length; i++){
            set.remove(nums[i - k - 1]);
            if(! set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
