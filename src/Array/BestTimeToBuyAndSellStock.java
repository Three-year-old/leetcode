package Array;

public class BestTimeToBuyAndSellStock {

    private int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        profit[0] = 0;
        int value = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[i] = prices[i] - prices[i - 1];
        }
        for (int i = 1; i < profit.length; i++) {
            profit[i] += Math.max(profit[i - 1], 0);
            value = Math.max(value, profit[i]);
        }
        return value;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(prices));
    }
}
