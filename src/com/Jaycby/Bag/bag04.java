package com.Jaycby.Bag;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @ClassName bag04
 * @Author cby
 * @Date 2022/12/3 13:51
 * @Version 1.0
 * 01背包问题，但是本题：背包有两个维度，装满这个背包有多少种物品
 */
public class bag04 {

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int maxForm = findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
