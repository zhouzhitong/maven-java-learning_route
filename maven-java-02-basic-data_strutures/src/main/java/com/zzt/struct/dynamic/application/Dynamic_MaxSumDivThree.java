package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>1262. 可被三整除的最大和
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * </>
 *
 * @author zzt
 */
public class Dynamic_MaxSumDivThree {

    @Test
    public void test01() {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSumDivN(nums, 3);
    }

    private int maxSumDivN(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k];
        for (int j = 0; j < k; ++j) {
            dp[0][j] = 0;
        }
        boolean[] flag = new boolean[k];
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 0; j < k; ++j) {
                int sum = dp[i][j] + num;
                int ii = sum % k;
                flag[ii] = true;
                dp[i + 1][ii] = Math.max(sum,
                        Math.max(dp[i + 1][ii], dp[i][ii]));
            }
            for (int j = 0; j < k; ++j) {
                if (flag[j])
                    flag[j] = false;
                else
                    dp[i + 1][j] = dp[i][j];
            }
        }
        return dp[n][0];
    }
}
