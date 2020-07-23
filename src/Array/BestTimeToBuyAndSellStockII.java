package Array;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        profit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i] = prices[i] - prices[i - 1];
        }
        for (int i = 1; i < profit.length; i++) {
            if (profit[i] < 0) {
                profit[i] = Math.max(profit[i - 1], 0);
            } else {
                profit[i] += Math.max(profit[i - 1], 0);
            }
        }
        return profit[prices.length - 1];
    }
}
