package com.Jaycby.Bag;

/**
 * @ClassName NumDistinct
 * @Author cby
 * @Date 2023/1/6 21:00
 * @Version 1.0
 */
public class NumDistinct {

    public static void main(String[] args) {

        String s = "babgbag";
        String t = "bag";
        int i = numDistinct(s, t);
    }

    public static int numDistinct(String s, String t) {

        int[][] dp = new int[s.length()][t.length()];

        // dp[i][j]代表以下标i，j结尾，s的子序列中t出现的个数
        // 初始化
        for (int i = 0; i < s.length(); i++){
            if (i == 0){
                if (s.charAt(i) == t.charAt(0)){
                    dp[i][0] = 1;
                }else{
                    dp[i][0] = 0;
                }
            }else {
                if (s.charAt(i) == t.charAt(0)){
                    dp[i][0] = dp[i - 1][0] + 1;
                }else{
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        for (int i = 0; i < t.length(); i++){
            if ((i == 0) && (t.charAt(i) == s.charAt(0))){
                dp[0][i] = 1;
                continue;
            }
            dp[0][i] = 0;
        }

        for (int i = 1; i < s.length(); i++){
            for (int j = 1; j < t.length(); j++){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }

        return  dp[s.length() - 1][t.length() - 1];
    }
}
