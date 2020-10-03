package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br>
 * 网址：https://leetcode-cn.com/problems/two-sum/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/3 17:12
 **/
public class Solution_001 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int a2;
        for (int i = 0; i < nums.length; i++) {
            if ((a2 = findOne(nums, i, target - nums[i])) != -1) {
                result[0] = i;
                result[1] = a2;
                return result;
            }
        }

        return result;
    }

    private int findOne(int[] nums, int i, int target) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[j] == target) {
                return j;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 9;
        int[] ints = new Solution_001().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
