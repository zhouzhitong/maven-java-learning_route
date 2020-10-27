package com.zzt.leet_code_13;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>1365. 有多少小于当前数字的数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 14:21
 */
public class Solution_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int index;
        Integer t;
        for (int num : nums) {
            t = map.get(num);
            map.put(num, t != null ? t + 1 : 1);
        }
        t = 0;
        for (Integer num : map.keySet()) {
            index = map.get(num);
            map.put(num, t);
            t += index;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    @Test
    public void test01() {
        int[] nums = {60, 14, 3, 39, 49, 43, 53, 24, 33, 13, 32, 93, 65
                , 26, 77, 55, 2, 28, 2, 50, 18, 4, 92, 20, 57, 90
                , 64, 86, 54, 69, 28, 80, 88, 66, 57, 28, 67, 83, 3, 50, 86};
        int[] ints = new Solution_1365().smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ints));
    }
}
