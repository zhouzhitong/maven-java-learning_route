package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br> 123. 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * </>
 *
 * @author zzt
 */
public class Dynamic_MaxProfit {

    @Test
    public void test01() {
        int[] prices = {3, 3, 5, 0, 3, 4};
        System.out.println(new Solution02().maxProfit(prices));
    }

    /** 暴力递归求解 */
    private static class Solution01 {
        public int maxProfit(int[] prices) {
            return f(prices, 0, prices[0], 2);
        }

        private int f(int[] prices, int index, int prePrice, int count) {
            if (index == prices.length || count == 0) {
                return 0;
            }
            int p2 = f(prices, index + 1, prices[index], count);    // 买入
            int p1 = f(prices, index + 1, prePrice, count); // 不买
            int p3 = 0;
            if (prices[index] > prePrice) {
                p3 = (prices[index] - prePrice) +
                        f(prices, index + 1, Integer.MAX_VALUE, count - 1);   // 卖
            }
            int p4 = f(prices, index + 1, prePrice, count);     // 不卖
            return Math.max(Math.max(p1, p2), Math.max(p3, p4));
        }
    }

    private static class Solution02 {
        public int maxProfit(int[] prices) {
            return 0;
        }

    }

    /** 动态规划求解 */
    private static class Solution03 {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            int len = prices.length;
            int k = 2;
            int[] dp = new int[2 * k + 1];
            dp[0] = 0;
            dp[1] = -prices[0];
            for (int i = 2; i < 2 * k + 1; ++i) {
                dp[i] = Integer.MIN_VALUE;
            }
            int max = 0;
            for (int i = 1; i < len; ++i) {
                dp[0] = 0;
                dp[1] = Math.max(dp[1], dp[0] - prices[i]);
                for (int j = 2; j < 2 * k + 1; ++j) {
                    dp[j] = Math.max(dp[j], j % 2 == 0 ? dp[j - 1] + prices[i] : dp[j - 1] - prices[i]);
                    if (j % 2 == 0) {
                        max = Math.max(max, dp[j]);
                    }
                }
            }
            return max;
        }
    }
}