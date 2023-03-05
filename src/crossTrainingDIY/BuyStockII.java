package crossTrainingDIY;

public class BuyStockII {
    //you can make as many transactions you want
    public int maxProfitGreedy(int[] array) {
        int sum = 0;
        for(int i = 1; i < array.length; i++){
            sum += Math.max(0, array[i] - array[i - 1]);
        }
        return sum;
    }

    public int DP(int[] array){
        int[][] helper = new int[array.length][2];
        helper[0][0] = 0;//后面的index为0表示该日交易完之后手中没有股票
        helper[0][1] = - array[0];
        for(int i = 1; i < array.length; i++){
            helper[i][0] = Math.max(helper[i - 1][0], helper[i - 1][1]+ array[i]);
            helper[i][1] = Math.max(helper[i - 1][1], helper[i - 1][0] - array[i]);
        }
        return helper[array.length - 1][0];
    }

    public int betterDP(int[] array){
        int noStock = 0;
        int stock = - array[0];
        for(int i = 1; i < array.length; i++){
            int newNoStock = Math.max(noStock, stock + array[i]);
            int newStock = Math.max(stock, noStock - array[i]);
            noStock = newNoStock;
            stock = newStock;
        }

        return noStock;
    }
}
