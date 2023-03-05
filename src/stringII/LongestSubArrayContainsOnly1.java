package stringII;

public class LongestSubArrayContainsOnly1 {
    // can skip k 0s
    public int longest(int[] nums, int k){
        if(nums == null || nums.length == 0 || k < 0){
            return -1;
        }

        int globalMax = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while(j < nums.length){
            if(nums[j] == 1){
                globalMax = Math.max(globalMax, j - i + 1);
            }
            else{
                if(count < k){
                    globalMax = Math.max(globalMax, j - i + 1);
                    count++;
                }
                else{
                    while(nums[i] != 0){
                        i++;
                    }
                    i++;
                }
            }
            j++;
        }

        return globalMax;


    }
}
