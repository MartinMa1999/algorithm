package Advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WiggleSortII {
    // Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    public static void main(String[] args) {
        WiggleSortII test = new WiggleSortII();
        test.wiggleSort(new int[]{486,225,458,198,17,406,223,437,362,422,123,367,38,61,351,29,341,165,164,412,487,29,427,373,395,7,282,418,462,424,305,25,169,55,206,373,29,326,58,275,192,76,196,253,351,472,392,254,452,220,190,249,291,438,159,56,18,196});

    }

    public int[] wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;;
        if(nums.length % 2 == 0){
            count = nums.length / 2;
        }
        else{
            count = nums.length / 2 + 1;
        }

        int num = 0;
        int num1 = 0;
        int[] small = new int[count];
        int[] large = new int[nums.length - count];
        Set<Integer> set = map.keySet();

        for(int j : set){
            int value = map.get(j);
            for(int i = 0; i < value; i++){
                if(num < count){
                    small[num++] = j;
                }
                else{
                    large[num1++] = j;
                }
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < small.length || j < large.length){
            if(i < small.length){
                nums[k++] = small[i++];
            }

            if(j < large.length){
                nums[k++] = large[j++];
            }
        }

        return nums;

    }
}
