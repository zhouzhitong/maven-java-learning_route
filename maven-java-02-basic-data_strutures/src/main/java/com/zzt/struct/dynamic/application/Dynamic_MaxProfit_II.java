package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br> 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * </>
 *
 * @author zzt
 */
public class Dynamic_MaxProfit_II {

    @Test
    public void test01() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }

    /** 贪心算法求解 */
    private static class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int p1;
            int p2;
            for (int i = 1; i < prices.length; i++) {
                while (i < prices.length && prices[i] < prices[i - 1]) {
                    i++;
                }
                p1 = prices[i - 1];

                while (i < prices.length && prices[i] > prices[i - 1]) {
                    i++;
                }
                p2 = prices[i - 1];
                maxProfit += p2 - p1;
            }
            return maxProfit;
        }
    }

}
