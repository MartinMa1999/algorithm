package crossTrainingDIY;

public class BuyStockIII {
    //On each day you can only make one operation: either buy or sell one unit of stock,
    // at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total.
    // Determine the maximum profit you can make.
    public int buyStock(int[] array){
        int buy1 = - array[0];
        int sell1 = 0;
        int buy2 = - array[0];
        int sell2 = 0;

        for(int i = 1; i < array.length; i++){
            buy1 = Math.max(buy1, - array[i]);
            sell1 = Math.max(sell1, buy1 + array[i]);
            buy2 = Math.max(buy2, sell1 - array[i]); // 注意这里必须是卖一次获得的利润sell1 - 当前买入付出的array[i]
            sell2 = Math.max(sell2, buy2 + array[i]);
        }
        return sell2;

        //无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，这是因为这一操作带来的收益为零。
    }
}
