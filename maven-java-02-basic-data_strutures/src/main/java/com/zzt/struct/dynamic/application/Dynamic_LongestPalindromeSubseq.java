package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

/**
 描述：<br>最长回文序列（可中断，即去除中间部分字符）
 </>
 @author zzt */
public class Dynamic_LongestPalindromeSubseq {

    @Test
    public void test01() {
        String s = "bbbab";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        System.out.println(new Solution1().longestPalindromeSubseq(s));
    }

    /** 暴力递归版本 */
    private static class Solution {
        public int longestPalindromeSubseq(String s) {
            return process(s.toCharArray(), 0, s.length() - 1);
        }

        private int process(char[] cs, int l, int r) {
            if (l == r) {
                return 1;
            }
            if (l == r - 1) {
                return cs[l] == cs[r] ? 2 : 1;
            }
            int p1 = process(cs, l + 1, r - 1);
            int p2 = process(cs, l, r - 1);
            int p3 = process(cs, l + 1, r);
            int p4 = cs[l] != cs[r] ? 0 : (2 + process(cs, l + 1, r - 1));
            return Math.max(Math.max(p1, p2), Math.max(p3, p4));
        }
    }

    private static class Solution1 {

        public int longestPalindromeSubseq(String s) {
            return process(s.toCharArray(), 0, s.length() - 1);
        }

        private int process(char[] chars, int l, int r) {
            if (l == r) {
                return 1;
            }
            if (l + 1 == r) {
                return chars[l] == chars[r] ? 2 : 1;
            }
            int p1 = process(chars, l + 1, r);
            int p2 = (chars[l] == chars[r] ? 2 : 0) + process(chars, l + 1, r - 1);
            int p3 = process(chars, l, r - 1);
            return Math.max(p1, Math.max(p2, p3));
        }

    }

    /** 动态规划版本 */
    private static class Solution01 {
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            char[] str = s.toCharArray();
            int N = str.length;
            int[][] dp = new int[N][N];
            dp[N - 1][N - 1] = 1;
            for (int i = 0; i < N - 1; i++) {
                dp[i][i] = 1;
                dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
            }
            for (int L = N - 3; L >= 0; L--) {
                for (int R = L + 2; R < N; R++) {
                    dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                    if (str[L] == str[R]) {
                        dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                    }
                }
            }
            return dp[0][N - 1];
        }
    }

}
