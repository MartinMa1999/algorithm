package DPTopic;

public class PaintFence {
    // There is a fence with n posts, each post can be painted with one of the k colors.
    //
    //You have to paint all the posts such that no more than two adjacent fence posts have the same color.
    //
    //Return the total number of ways you can paint the fence.

    // 每次需要考虑两种情况，第一种是当前和上一个同色，第二种是当前和上一个不同色且上一个和上上个同色。由于要找所有解，所以一定是能同色就同色

    public int numWays(int n, int k) {
        if(n == 0 || k == 0){
            return 0;
        }
        if(n == 1){
            return k;
        }


        int[] helper = new int[n];
        helper[0] = k;
        helper[1] = k * k;
        for(int i = 2; i < n; i++){
            helper[i] = (k - 1) * helper[i - 2] + (k - 1) * helper[i - 1];
        }
        return helper[n - 1];

    }
}
