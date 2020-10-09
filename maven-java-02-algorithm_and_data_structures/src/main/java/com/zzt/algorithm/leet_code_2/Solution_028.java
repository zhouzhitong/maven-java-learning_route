package com.zzt.algorithm.leet_code_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br> 28. 实现strStr()
 * 网址：https://leetcode-cn.com/problems/implement-strstr/
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/9 14:22
 */
public class Solution_028 {

    public int strStr(String haystack, String needle) {
        Pattern compile = Pattern.compile(needle);
        Matcher matcher = compile.matcher(haystack);
        if (matcher.find()){
            return matcher.start();
        }
        return -1;
    }

    /*public int strStr(String haystack, String needle) {
        if (haystack.length() <= needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        char[] str = haystack.toCharArray();
        char[] match = needle.toCharArray();
        int[] arr = getArr(match);
        int p1 = 0, p2 = 0;
        while (p1 < str.length && p2 < match.length) {
            if (str[p1] == match[p2]) {
                p1++;
                p2++;
            } else if (p2 == 0) {
                p1++;
            } else {
                p2 = arr[p2];
            }
        }
        return p2 == match.length ? p1 - p2 : -1;
    }*/

    private int[] getArr(char[] match) {
        int[] t = new int[match.length];
        t[0] = -1;
        t[1] = 0;
        for (int i = 2; i < match.length; i++) {
            t[i] = getNext(match, i - 1);
        }
        return t;
    }

    private int getNext(char[] match, int x) {
        int j, y;
        for (int len = x; len > 0; len--) {
            j = 0;
            y = x - len + 1;
            while (j < len) {
                if (match[j] == match[y]) {
                    j++;
                    y++;
                } else {
                    break;
                }
            }
            if (j == len) {
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String haystack = "aasdasd";
        String match = "das";
        int i = new Solution_028().strStr(haystack, match);
        System.out.println(i);
    }

}
