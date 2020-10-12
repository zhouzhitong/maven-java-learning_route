package com.zzt.algorithm.leet_code_2;

import com.zzt.algorithm.leet_code_3.Solution_530;

/**
 * 描述：<br> 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/12 15:25
 */
public class Solution_005 {

    public String longestPalindrome(String s) {
        if (s.length()<=1){
            return s;
        }
        String maxLong = "";
        String t;
        int len = s.length() - 1;
        for (int mid = 0; mid < len; mid++) {
            t = getMaxLong(s, mid);
            if (t.length() > maxLong.length()) {
                maxLong = t;
            }
            t = check(s, mid, mid + 1);
            if (t.length() > maxLong.length()) {
                maxLong = t;
            }
        }
        return maxLong;
    }

    private String getMaxLong(String s, int mid) {
        int i = mid - 1, j = mid + 1;
        return check(s, i, j);
    }

    private String check(String s, int i, int j) {
        while (i > -1 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "bb";
        String s1 = new Solution_005().longestPalindrome(s);
//        String s1 = new Solution_005().getMaxLong(s, 3);
        System.out.println(s1);
    }

}
