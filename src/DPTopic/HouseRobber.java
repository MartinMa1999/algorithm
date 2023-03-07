package DPTopic;

public class HouseRobber {
    // You are a skilled robber planing to rob houses along a street. Each house has a certain amount of gold in it,
    // but if you rob two adjacent houses the security system will automatically contact the police.
    //
    //Given a list of non-negative integers representing the amount of gold in each house,
    // return the maximum amount of gold you can rob without being caught.

    public int rob(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        int rob = num[0];
        int norob = 0;

        for(int i = 1; i < num.length; i++){
            int rob1 = rob;
            int norob1 = norob;
            rob = norob1 + num[i];
            norob = Math.max(rob1, norob1); // bug !!如果当前不rob，则上一轮可能是任何情况
        }
        return Math.max(rob, norob);
    }
}
