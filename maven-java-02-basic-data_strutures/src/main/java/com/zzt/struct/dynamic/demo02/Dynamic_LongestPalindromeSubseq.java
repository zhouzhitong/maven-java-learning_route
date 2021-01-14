package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>最长回文序列（可中断，即去除中间部分字符）
 * </>
 *
 * @author zzt
 */
public class Dynamic_LongestPalindromeSubseq {

    @Test
    public void test01() {
        String s = "a12bc32d1f";
//        String s = "bbabb";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        System.out.println(new Solution01().longestPalindromeSubseq(s));
    }

    /** 暴力递归版本 */
    private static class Solution {
        public int longestPalindromeSubseq(String s) {
            char[] chars = s.toCharArray();
            return process(chars, 0, s.length() - 1);
        }

        private int process(char[] cs, int l, int r) {
            if (l == r) {
                return 1;
            }
            if (l + 1 == r) {
                return cs[l] == cs[r] ? 2 : 1;
            }
            int p1 = process(cs, l + 1, r);
            int p2 = (cs[l] == cs[r] ? 2 : 0) + process(cs, l + 1, r - 1);
            int p3 = process(cs, l, r - 1);
            return Math.max(p1, Math.max(p2, p3));
        }

    }

    /** 动态规划版本 */
    private static class Solution01 {
        public int longestPalindromeSubseq(String s) {
            if (s.length() < 2) {
                return s.length();
            }
            int N = s.length();
            int[][] dp = new int[N][N];
            dp[N - 1][N - 1] = 1;
            for (int i = 0; i < N - 1; i++) {
                dp[i][i] = 1;
                dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1))
                        ? 2 : 1;
            }
            // 从下往上填 dp表
            /*for (int i = N - 3; i >= 0; i--) {
                for (int j = i + 2; j < N; j++) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = Math.max(dp[i][j], 2 + dp[i + 1][j - 1]);
                    }
                }
            }*/
            // 对角线填写 dp 表
            for (int i = 2; i < N; i++) {
                for (int j = 0; i + j < N; j++) {
                    int t = i + j;
                    int toLeft = t - 1;
                    int toDown = j + 1;
                    dp[j][t] = Math.max(dp[toDown][t], dp[j][toLeft]);
                    if (s.charAt(t) == s.charAt(j)) {
                        dp[j][t] = Math.max(dp[j][t], 2 + dp[toDown][toLeft]);
                    }
                }
            }


            return dp[0][N - 1];
        }
    }

}
