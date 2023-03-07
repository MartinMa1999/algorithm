package Advanced;

public class LongestSubarrayWithEqualNumberOf1sAnd0s {
    // Given an unsorted array with all 0 or 1s. Return the length of the longest contiguous sub-array that contains equal numbers of 0s and 1s.

    public static void main(String[] args) {
        LongestSubarrayWithEqualNumberOf1sAnd0s test = new LongestSubarrayWithEqualNumberOf1sAnd0s();
        test.longest(new int[]{0,0,0,1,0,0,1,1,1});
    }

    public int longest(int[] array) {
        if(array == null || array.length <= 1){
            return 0;
        }

        int[] prefix1 = new int[array.length];
        int[] prefix2 = new int[array.length];
        if(array[0] == 0){
            prefix1[0] = 1;
        }
        else{
            prefix2[0] = 1;
        }
        int result = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] == 0){
                prefix1[i] = prefix1[i - 1] + 1;
                prefix2[i] = prefix2[i - 1];
            }
            else{
                prefix1[i] = prefix1[i - 1];
                prefix2[i] = prefix2[i - 1] + 1;
            }
            if(prefix1[i] == prefix2[i]){
                result = Math.max(result, i + 1); // bug!
            }
            for(int j = 0; j < i; j++){
                if(prefix1[i] - prefix1[j] == prefix2[i] - prefix2[j]){
                    result = Math.max(result, i - j); // bug! 必须是i - j
                }
            }
        }

        return result;

    }
}
