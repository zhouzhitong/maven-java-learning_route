package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br> 27. 移除元素
 * 网址：https://leetcode-cn.com/problems/remove-element/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/8 8:19
 **/
public class Solution_027 {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int i = new Solution_027().removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}
