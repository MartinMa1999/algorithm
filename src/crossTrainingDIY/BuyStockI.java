package crossTrainingDIY;

public class BuyStockI {
    // Given an array of positive integers representing a stock’s price on each day.
    // On each day you can only make one operation: either buy or sell one unit of stock and you can make at most 1 transaction.
    // Determine the maximum profit you can make.
    // 买入必须在卖出之前
    public int maxProfit(int[] array) {
        int min = Math.min(array[0], array[1]);
        int globalMax = array[1] - array[0];
        for(int i = 2; i < array.length; i++){
            globalMax = Math.max(globalMax, array[i] - min);
            min = Math.min(min, array[i]);
        }
        return Math.max(globalMax, 0);
    }
}
