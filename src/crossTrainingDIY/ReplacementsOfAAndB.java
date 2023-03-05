package crossTrainingDIY;

public class ReplacementsOfAAndB {
    // Given a string with only character 'a' and 'b', replace some characters such that
    // the string becomes in the forms of all the 'b's are on the right side of all the 'a's.

    //从左到右数: 在index = i 的时候, DP1[i] = 如果把0~i全变成'a'需要多少次替换
    //
    //从右到左数: 在index = i 的时候 DP2[i] = 如果吧i~len-1全变成'b'需要多少次替换.
    //
    //最后算从0~len-1 , 哪里DP1[i] + DP2[i + 1] 的值最低.

    public int minReplacements(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }

        int[] left = new int[input.length()];
        if(input.charAt(0) == 'b'){
            left[0] = 1;
        }
        int[] right = new int[input.length()];
        if(input.charAt(input.length() - 1) == 'a'){
            right[input.length() - 1] = 1;
        }
        for(int i = 1; i < left.length; i++){
            if(input.charAt(i) == 'b'){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = left[i - 1];
            }
        }

        for(int i = right.length - 2; i >= 0; i--){
            if(input.charAt(i) == 'a'){
                right[i] = right[i + 1] + 1;
            }
            else{
                right[i] = right[i + 1];
            }
        }
        int globalMin = Integer.MAX_VALUE;
        for(int i = 0; i < left.length - 1; i++){
            globalMin = Math.min(globalMin, left[i] + right[i + 1]);
        }

        globalMin = Math.min(globalMin, Math.min(left[left.length - 1], right[0]));
        return globalMin;
    }
}
