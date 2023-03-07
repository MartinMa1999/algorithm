package leetCode;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
    // leetcode 1626
    //You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.
    //
    //However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.
    //
    //Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.

    public int bestTeamScore(int[] scores, int[] ages) {
        if(scores == null || scores.length == 0 || ages == null || ages.length == 0){
            return 0;
        }
        int n = scores.length;
        int[][] helper = new int[n][2];
        for(int i = 0; i < n; i++){
            helper[i][0] = scores[i];
            helper[i][1] = ages[i];
        }

        Arrays.sort(helper, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int[] dp = new int[n];
        dp[0] = helper[0][0]; // 我认为dp中存的是到目前的highest score
        int result = dp[0];
        for(int i = 1; i < n; i++){
            int tmp = 0;
            for(int j = 0; j < i; j++){ // 相当于每一次都回头去找之前存的所有valid的情况，然后找到所有valid的最大值
                if(helper[j][0] <= helper[i][0]){ // bug！注意可以等于
                    tmp = Math.max(tmp, dp[j]);
                }
            }

            dp[i] = helper[i][0] + tmp;

            result = Math.max(result, dp[i]);
        }

        return result;

    }













}
