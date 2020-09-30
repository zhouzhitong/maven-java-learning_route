package com.zzt.algorithm.find;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/29 16:52
 **/
public class KMP_CodeDemo01 {

    public static int match(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0, y = 0;
        int[] nextArr = getNextArr(match);
        while (x < s.length() && y < m.length()) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = nextArr[y];
            }
        }
        return y == match.length ? x - y : -1;
    }

    private static int[] getNextArr(char[] match) {
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int y;
        for (int i = 2; i < next.length; i++) {
            next[i] = getInt(match, i - 1);
        }
        return next;
    }

    private static int getInt(char[] match, int y) {
        int x, j;
        int m = 0;
        for (int i = 1; i <= y; i++) {
            x = 0;
            j = y - i + 1;
            while (x < i && match[x] == match[j]) {
                x++;
                j++;
            }
            if (x == i) {
                m = x;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        String s = "abcabcabcddd";
        String m = "abcddd";
        int match = match(s, m);
        System.out.println(match);
    }

}
