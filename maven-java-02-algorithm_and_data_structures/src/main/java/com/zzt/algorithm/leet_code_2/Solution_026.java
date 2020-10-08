package com.zzt.algorithm.leet_code_2;

import java.util.*;

/**
 * 描述：<br> 26. 删除排序数组中的重复项
 * 网址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/7 23:37
 **/
public class Solution_026 {

    // 优化后
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                nums[count++] = pre;
            }
        }
        return count;
    }
    // 优化前
    /*public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        int pre = nums[0];
        queue.offer(pre);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                queue.offer(pre);
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i] = queue.poll();
        }
        return count;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int count = new Solution_026().removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

}
