package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 参考：
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * </>
 *
 * @author zzt
 */
public class Dynamic_LongestPalindrome {

    @Test
    public void test01() {
        String s = "babbd";
        System.out.println(new Solution01().longestPalindrome(s));
        System.out.println(new Solution02().longestPalindrome(s));
    }

    /** 暴力求解 + 中心扩散 */
    private static class Solution01 {
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            String res = "";
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length() - 1; j >= i; j--) {
                    if (res.length() < j - i + 1
                            && validPalindromic(chars, i, j)) {
                        StringBuilder builder = new StringBuilder();
                        for (int k = i; k <= j; k++) {
                            builder.append(chars[k]);
                        }
                        res = builder.toString();
                    }
                }
            }

            return res;
        }

        /**
         * 验证子串 s[left..right] 是否为回文串
         */
        private static boolean validPalindromic(char[] chars, int l, int r) {
            while (l < r) {
//                System.out.println(l + " -- " + r);
                if (chars[l++] != chars[r--]) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class Solution02 {
        public String longestPalindrome(String s) {
            // 特判
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i, j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            char[] charArray = s.toCharArray();

            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }

}
