package com.zzt.leet_code_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 描述：<br>239. 滑动窗口最大值
 https://leetcode-cn.com/problems/sliding-window-maximum/
 </>
 @author 周志通
 @version 1.0.0
 @date 2021/1/2 22:48 **/
public class Solution_239 {

    @Test
    public void test01() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int subLen = nums.length - k + 1;
        if (subLen < 1) {
            return null;
        }
        int[] result = new int[subLen];
        for (int i = 0; i < subLen; i++) {
            int sum = Integer.MIN_VALUE;
            int j = i;
            int x = i + k;
            while (j < x) {
                sum = Math.max(sum, nums[j]);
                j++;
            }
            result[i] = sum;
        }
        return result;
    }

}
