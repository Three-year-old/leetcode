package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int has = 0;
        int not = -prices[0];
        for (int price : prices) {
            has = Math.max(has, not + price - fee);
            not = Math.max(not, has - price);
        }
        return has;
    }
}
