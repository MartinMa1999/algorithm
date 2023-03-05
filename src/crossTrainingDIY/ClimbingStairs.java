package crossTrainingDIY;

public class ClimbingStairs {
    // There are in total n steps to climb until you can reach the top. You can climb 1 or 2 steps a time.
    // Determine the number of ways you can do that.
    public int stairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] helper = new int[n + 1];
        helper[n] = 1;
        helper[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            helper[i] = helper[i + 1] + helper[i + 2]; // 相当于斐波那契数列
        }
        return helper[0];
    }

    public int betterWay(int n){
        if(n <= 1){
            return 1;
        }
        int tmp1 = 1;
        int tmp2 = 1;

        while(n > 1){
            int tmp = tmp1;
            tmp1 += tmp2;
            tmp2 = tmp;
            n--;
        }


        return tmp1;
    }
}
