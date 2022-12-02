package com.Jaycby.Bag;

/**
 * @ClassName bag01
 * @Author cby
 * @Date 2022/12/2 20:08
 * @Version 1.0
 */
public class bag01 {

    public static void main(String[] args) {

        int[] nums = {1,5,11,5};
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(dp[target] == target);
    }
}
