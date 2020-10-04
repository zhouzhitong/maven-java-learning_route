package com.zzt.algorithm.find;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/4 16:21
 **/
public class KMP_CodeDemo02 {

    public static int match(String s, String m) {
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int[] arr = getArr(match);
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < m.length()) {
            if (str[p1] == match[p2]) {
                p1++;
                p2++;
            } else if (p2 == 0) {
                p1++;
            } else {
                p2 = arr[p2];
            }
        }
        return p2 == m.length() ? p1 - p2 : -1;
    }

    private static int[] getArr(char[] m) {
        int[] arr = new int[m.length];
        arr[0] = -1;
        arr[1] = 0;
        for (int i = 2; i < m.length; i++) {
            arr[i] = getNextCount(m, i);
        }
        return arr;
    }

    private static int getNextCount(char[] m, int s) {
        int temp = 0, e = s - 1;
        int len = 1, x, y;
        for (int i = 0; i < e; i++) {
            x = 0;
            y = s - len;
            while (x < len) {
                if (m[x] != m[y++]) {
                    break;
                }
                x++;
            }
            if (x == len) {
                temp = len;
            }
            len++;
        }
        return temp;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabcddd";
        String m = "abcddd";
        int match = match(s, m);
        System.out.println(match);
    }

}
