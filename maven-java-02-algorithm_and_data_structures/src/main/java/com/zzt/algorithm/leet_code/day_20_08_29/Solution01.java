package com.zzt.algorithm.leet_code.day_20_08_29;

/**
 * 描述：<br>214. 最短回文串
 * 网址：https://leetcode-cn.com/problems/shortest-palindrome/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/29 17:06
 */
public class Solution01 {

    public String shortestPalindrome(String s) {
        int len = s.length();
        int count = 0;
        String newStr = s;
        while (true) {
            // 判断是否回文
            if (judge_is_palindrome(newStr)) {
                return newStr;
            } else {
                newStr = returnNewStr(s, len, ++count);
            }
        }
    }

    private boolean judge_is_palindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        return builder.toString().equals(s);
    }

    private String returnNewStr(String s, int len, int count) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < count; i++) {
            builder.insert(i, s.charAt(len - 1 - i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "asdasdasdasd";
        System.out.println(new Solution01().shortestPalindrome(s));

    }

}