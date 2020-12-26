package com.zzt.leet_code_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * </>
 *
 * @author zzt
 */
public class Solution_455 {

    @Test
    public void test01() {
        int[] g = {1, 2, 3};
        int[] s = {1, 2};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0
                || s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int p2 = 0;
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            int k = g[i];
            for (int j = p2; j < s.length; j++) {
                if (s[j] >= k) {
                    count++;
                    p2 = j + 1;
                    break;
                }
            }
        }
        return count;
    }
}
