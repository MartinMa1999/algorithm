package DPTopic;

public class PaintHouse {
    // There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
    // The cost of painting each house with a certain color is different. You have to paint all the houses such that
    // no two adjacent houses have the same color.
    //
    //The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    // For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1
    // with color green, and so on... Find the minimum cost to paint all houses.

    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;

        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for(int i = 1; i < n; i++){
            int red1 = red;
            int blue1 = blue;
            int green1 = green;
            red = Math.min(blue1, green1) + costs[i][0];
            blue = Math.min(red1, green1) + costs[i][1];
            green = Math.min(red1, blue1) + costs[i][2];
        }

        return Math.min(Math.min(red, blue), green);
    }
}
