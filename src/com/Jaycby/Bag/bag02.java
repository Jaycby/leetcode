package com.Jaycby.Bag;

/**
 * @ClassName bag02
 * @Author cby
 * @Date 2022/12/2 20:30
 * @Version 1.0
 */
public class bag02 {

    public static void main(String[] args) {


    }

    public int lastStoneWeightII(int[] stones) {

        int length = stones.length;
        if (length < 1){
            return 0;
        }
        if (length == 1){
            return stones[0];
        }
        int sum = 0;
        int target = 0;
        for (int i : stones) {
            sum += i;
        }
        target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j > stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
