package com.zzt.algorithm.leet_code_2;

/**
 * 描述：<br> 4. 寻找两个正序数组的中位数
 * 网址：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/4 11:39
 **/
public class Solution_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        int x = 2, p1 = 0, p2 = 0;
        while (x < left) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
            x++;
        }

        return 0.0;
    }

    public static void main(String[] args) {

    }

}
