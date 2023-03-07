import java.util.*;

public class Practice {
    public static void main(String[] args) {
//       Practice practice = new Practice();
//       practice.minFlipsMonoIncr  ,mb("100000001010000");

        final long a = 24L * 60 * 60 * 1000 * 1000;
        final long b = 24 * 60 * 60 * 1000;
        System.out.println(Integer.MAX_VALUE + 1);
    }

    public int minFlipsMonoIncr(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int num0 = 0;
        int num1 = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                num1++;
                dp[i] = dp[i - 1];
            }
            else{
                num0++;
                if(num1 > 0){
                    dp[i] = Math.min(Math.min(num1, dp[i - 1] + 1), num0);
                }
                else{
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[dp.length - 1];
    }
}
