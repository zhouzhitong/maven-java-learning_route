package com.zzt.algorithm.leet_code.day_20_08_30;

/**
 * 描述：<br>557. 反转字符串的单词|||
 * 网址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/30 16:25
 **/
public class Solution01 {
    public String reverseWords(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        char[] cs = s.toCharArray();
        int start = 0, end;
        char temp;
        for (int i = 0; i < cs.length; i++) {
            if (i == cs.length - 1 || cs[i + 1] == ' ') {
                end = i;
                while (start < end) {
                    temp = cs[start];
                    cs[start++] = cs[end];
                    cs[end--] = temp;
                }
                start = i + 2;
            }
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
//        String s = "I love u";
        System.out.println(new Solution01().reverseWords(s));
    }

}
