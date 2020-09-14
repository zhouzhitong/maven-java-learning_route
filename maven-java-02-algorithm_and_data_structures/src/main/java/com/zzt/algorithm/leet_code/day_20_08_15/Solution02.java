package com.zzt.algorithm.leet_code.day_20_08_15;

import java.util.Arrays;

/**
 * 描述：<br> 算法 -- 88. 合并两个有序数组
 * 网址：https://leetcode-cn.com/problems/merge-sorted-array/
 * 思路：快速排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/15 17:28
 */
public class Solution02 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < n+m; ++i, ++j) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        new Solution02().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
