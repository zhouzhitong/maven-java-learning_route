package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br> 75. 颜色分类
 * 网址：https://leetcode-cn.com/problems/sort-colors/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/7 22:37
 **/
public class Solution_075 {
    // 利用 桶排序（ O(n) ）
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        int i = 0, k = 0;
        for (int count : counts) {
            while (count > 0) {
                nums[i++] = k;
                count--;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution_075().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
