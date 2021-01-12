package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

/**
 * ������<br>5. ������Ӵ�
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * �ο���
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

    /** ������� + ������ɢ */
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
         * ��֤�Ӵ� s[left..right] �Ƿ�Ϊ���Ĵ�
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
            // ����
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            // dp[i][j] ��ʾ s[i, j] �Ƿ��ǻ��Ĵ�
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

                    // ֻҪ dp[i][j] == true �������ͱ�ʾ�Ӵ� s[i..j] �ǻ��ģ���ʱ��¼���ĳ��Ⱥ���ʼλ��
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
