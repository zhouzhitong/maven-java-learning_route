package com.zzt.lcp_1;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>LCP 22. 黑白方格画
 * https://leetcode-cn.com/problems/ccw6C7/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/21 22:47
 **/
public class Solution_LCP_022 {

    public int paintingPlan(int n, int k) {
        if (n * n == k) {
            return 1;
        }
        int result = 0;
        int help;
        int i = 1, j;
        while ((help = i * n) <= k) {
            if (help == k) {
                result += getCount(i, n);
            } else {
                j = 1;
                while (help < k) {
                    help += n * j - 1;
                    j++;
                }
                if (help == k) {
                    result += getCount(j, n);
                }
            }
            i++;
        }
        return result << 1;
    }

    private int getCount(int i, int n) {
        int t1 = 1, t2 = 1;
        int m1 = n, m2 = i;
        for (int j = 0; j < i; j++) {
            t1 *= m1--;
            t2 *= m2--;
        }
        return t1 / t2;
    }

    @Test
    public void test01() {
        int count = new Solution_LCP_022().paintingPlan(3, 8);
//        int count = new Solution_LCP_022().getCount(1, 2);
        System.out.println(count);
    }

}
