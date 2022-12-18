package com.Jaycby.Bag;

/**
 * @ClassName coinChange
 * @Author cby
 * @Date 2022/12/18 14:53
 * @Version 1.0
 */
public class coinChange {

    public static void main(String[] args) {

        int[] coin = {2};
        int i = coinChangeApi(coin, 3);
        System.out.println(i);
    }

    public static int coinChangeApi(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                if (dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
