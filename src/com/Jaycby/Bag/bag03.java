package com.Jaycby.Bag;

/**
 * @ClassName bag03
 * @Author cby
 * @Date 2022/12/3 13:30
 * @Version 1.0
 * 装满这个背包有多少种方法
 */
public class bag03 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {

        int length = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int bagSize = (sum + target) / 2;
        //如果背包容量不是整数，说明不可行
        if ((sum + target) % 2 != 0){
            return 0;
        }
        if (bagSize < 0){
            bagSize = -bagSize;
        }
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
