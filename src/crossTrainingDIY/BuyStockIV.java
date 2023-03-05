package crossTrainingDIY;

import java.util.Arrays;

public class BuyStockIV {
    // you can make at most K transactions in total
    public int maxProfit(int[] array, int k) {
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, -array[0]);
        for (int i = 1; i < array.length; i++) {
            buy[0] = Math.max(buy[0], -array[i]);
            sell[0] = Math.max(sell[0], buy[0] + array[i]);
            for (int j = 1; j < buy.length; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - array[i]);
                sell[j] = Math.max(sell[j], buy[j] + array[i]);
            }
        }
        return sell[k - 1];
    }
}
