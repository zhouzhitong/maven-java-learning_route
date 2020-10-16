package com.zzt.algorithm.leet_code_3;

import java.util.*;

/**
 * 描述：<br>349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 17:08
 */
public class Solution_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        int[] nums = new int[result.size()];
        int count = 0;
        for (Integer integer : result) {
            nums[count++] = integer;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersection = new Solution_349().intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

}
