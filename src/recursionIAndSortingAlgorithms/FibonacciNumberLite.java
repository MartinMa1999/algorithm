package recursionIAndSortingAlgorithms;

public class FibonacciNumberLite {
    //the best way is using DP to solve the problem
    public int fibonacci(int k){
        if(k < 0){
            return 0;
        }
        if(k == 0 || k == 1){
            return 1;
        }
        return fibonacci(k - 1) + fibonacci(k - 2);
    }

    public int DP(int k){
        if(k < 0){
            return 0;
        }
        if(k == 0 || k == 1){
            return 1;
        }

        int helper1 = 1;
        int helper2 = 1;
        int count = 2;
        while(count <= k){
            int tmp = helper2;
            helper2 = helper1 + helper2;
            helper1 = tmp;
            count++;
        }
        return helper2;

    }


}
