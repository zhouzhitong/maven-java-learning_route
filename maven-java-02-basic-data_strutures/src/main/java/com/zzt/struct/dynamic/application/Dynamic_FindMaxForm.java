package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br> 474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * </>
 *
 * @author zzt
 */
public class Dynamic_FindMaxForm {

    @Test
    public void test01() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        int maxForm = findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] db = new int[m + 1][n + 1];
        for (String str : strs) {
            int one = 0;
            int zero = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            /*
                dp[i][j] 的结果有两种情况：
                    1、当前状态(dp[i][j])
                    2、上一个状态(dp[i - zeroNum][j - oneNum])的个数 + 1
             */
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    db[i][j] = Math.max(db[i][j], db[i - zero][j - one] + 1);
                }
            }
        }
        return db[m][n];
    }

}
