package DPTopic;

public class BestTimeBuySellStockWithCooldown {
    // Say you have an array for which the ith element is the price of a given stock on day i.
    //
    // Design an algorithm to find the maximum profit. You may complete as many transactions as you like
    // (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
    //
    // You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    // After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

    // 买股票一定是要算好当前操作和上一天的关系
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] freeze = new int[prices.length];
        buy[0] = - prices[0];
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], freeze[i - 1]);
            freeze[i] = buy[i - 1] + prices[i];
        }

        return Math.max(sell[prices.length - 1], freeze[prices.length - 1]);
    }

    public int betterWay(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }

        int buy = - prices[0];
        int sell = 0;
        int freeze = 0;
        for(int i = 1; i < prices.length; i++){
            int buy1 = buy;
            int sell1 = sell;
            int freeze1 = freeze;
            buy = Math.max(buy1, sell - prices[i]);
            sell = Math.max(sell1, freeze1);
            freeze = buy1 + prices[i];
        }

        return Math.max(sell, freeze);
    }
}
