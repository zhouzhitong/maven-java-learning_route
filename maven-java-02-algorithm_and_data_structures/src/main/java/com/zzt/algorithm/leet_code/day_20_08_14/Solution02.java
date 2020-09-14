package com.zzt.algorithm.leet_code.day_20_08_14;

/**
 * 描述：<br>买卖股票的最佳时机</>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 17:45
 */
public class Solution02 {

    /**
     * 网址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * 执行结果：
     *      执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *      内存消耗：39.5 MB, 在所有 Java 提交中击败了89.18%的用户
     *
     * @param prices
     * @return
     */
    public int getMaxValue(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(price - minPrice, maxProfit);
            }
        }

        return maxProfit;
    }

    /**
     * 网址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 执行结果：
     *      执行用时：1 ms, 在所有 Java 提交中击败了99.52%的用户
     *      内存消耗：39.6 MB, 在所有 Java 提交中击败了68.88%的用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     *
     * 网址：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/
     * 参考思路：
     *      https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-zui-jia-shi-ji-iiidong-tai-gui-hua/
     * 执行结果：
     *      执行用时：1 ms, 在所有 Java 提交中击败了99.91%的用户
     *      内存消耗：39.7 MB, 在所有 Java 提交中击败了77.35%的用户
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices.length<2) {
            return 0;
        }
        int len =  prices.length;
        int k = 2;
        int[] dp = new int[2*k+1];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 2;i<2*k+1;++i){
            dp[i] = Integer.MIN_VALUE;
        }
        int max = 0;
        for(int i=1;i<len;++i){
            dp[0] = 0;
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
            for(int j = 2;j<2*k+1;++j){
                dp[j] = Math.max(dp[j],j%2==0? dp[j-1]+prices[i]:dp[j-1]-prices[i]);
                if (j%2==0){
                    max = Math.max(max,dp[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution02().getMaxValue(num));
        System.out.println(new Solution02().maxProfit(num));
    }

}
