package com.zzt.leet_code_1;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * </>
 *
 * @author zzt
 */
public class Solution_189 {

    @Test
    public void test01() {
        int[] nums = {-1, -100, 3, 99};
        int k = 6;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        int index = nums.length - 1;
        int n = k % nums.length;
        for (int i = 0; i < n; i++) {
            int val = nums[index--];
            list.add(0, val);
        }
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = iterator.next();
        }
    }

}
