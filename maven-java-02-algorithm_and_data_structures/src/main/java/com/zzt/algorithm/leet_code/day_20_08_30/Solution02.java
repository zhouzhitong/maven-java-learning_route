package com.zzt.algorithm.leet_code.day_20_08_30;

/**
 * 描述：<br>33. 搜索螺旋转排序数组
 * 网址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/30 16:47
 **/
public class Solution02 {

    public int search(int[] nums, int target) {
        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            for (int i = 1; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
        } else {
            for (int j = nums.length - 1; j > 0; j--) {
                if (target == nums[j]) {
                    return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Solution02().search(nums, target));
    }

}
