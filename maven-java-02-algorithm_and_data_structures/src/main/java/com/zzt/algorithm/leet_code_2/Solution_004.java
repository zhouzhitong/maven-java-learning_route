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
        int total = nums1.length + nums2.length;
        int bz = total % 2; // 标志位：判断总长度的奇偶性质
        int mid = total >> 1; // 获取中间位置长度
        int p1 = 0, p2 = 0; // 移动指针
        int a1 = 0, a2 = 0; // 存储当前指针数据
        for (int i = 0; i <= mid; i++) {
            if (nums1.length <= p1
                    || (nums2.length > p2
                    && nums1[p1] >= nums2[p2])) {
                a1 = a2;
                a2 = nums2[p2];
                p2++;
            } else if (nums2.length <= p2
                    || nums1[p1] < nums2[p2]) {
                a1 = a2;
                a2 = nums1[p1];
                p1++;
            }
        }
        if (bz == 0) {
            return ((double) a1 + (double) a2) / 2;
        } else {
            return a2;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        double medianSortedArrays = new Solution_004().findMedianSortedArrays(num1, num2);
        System.out.println(medianSortedArrays);
    }

}
