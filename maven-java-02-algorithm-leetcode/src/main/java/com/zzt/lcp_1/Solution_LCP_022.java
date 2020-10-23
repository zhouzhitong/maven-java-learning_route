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
        if (n * n == k || k == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n * (i + j) - i * j == k) {
                    result += getCount(i, n) * getCount(j, n);
                }
            }
        }
        return result;
    }

    /*public int paintingPlan(int n, int k) {
        if (n * n == k || k == 0) {
            return 1;
        }
        int result = 0;
        int help;
        int i = 0, j;
        while ((help = i * n) <= k) {
            j = 0;
            int t = i == 0 ? 0 : 1;
            while (help < k) {
                help += n - t;
                j++;
            }
            if (help == k) {
                result += getCount(i, n) * getCount(j, n);
            }
            i++;
        }
        return result;
    }*/

    private int getCount(int i, int n) {
        if (i == 0) {
            return 1;
        }
        int t1 = 1, t2 = 1;
        int m1 = n, m2 = i;
        for (int j = 0; j < i; j++) {
            t1 *= m1--;
            t2 *= m2--;
        }
        return t1 / t2;
    }

    @Test
    public void test03() {
        int count = new Solution_LCP_022().paintingPlan(4, 13);
//        int count = new Solution_LCP_022().getCount(1, 2);
        System.out.println(count);
    }

    @Test
    public void test02() {
        int count = new Solution_LCP_022().paintingPlan(3, 8);
//        int count = new Solution_LCP_022().getCount(1, 2);
        System.out.println(count);
    }

    @Test
    public void test01() {
        int count = new Solution_LCP_022().paintingPlan(2, 2);
//        int count = new Solution_LCP_022().getCount(1, 2);
        System.out.println(count);
    }

}
