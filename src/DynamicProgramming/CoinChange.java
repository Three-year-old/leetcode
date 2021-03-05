package DynamicProgramming;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            boolean modify = false;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    if (min > dp[i - coin] + 1) {
                        min = dp[i - coin] + 1;
                        modify = true;
                    }
                }
            }
            if (modify) dp[i] = min;
        }
        return dp[amount];
    }
}
