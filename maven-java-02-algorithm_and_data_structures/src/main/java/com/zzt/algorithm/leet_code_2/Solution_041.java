package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br> 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/13 11:23
 */
public class Solution_041 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        for (int num : nums) {
            if (num == i) {
                i++;
            } else if (num > i) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        int i = new Solution_041().firstMissingPositive(nums);
        System.out.println(i);
    }
}
