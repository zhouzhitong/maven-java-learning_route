package com.zzt.leet_code_3;

import java.util.*;

/**
 * 描述：<br>349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/2 9:27
 */
public class Solution_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int p1 = 0, p2 = 0;
        while (p1<nums1.length&&p2<nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                set.add(nums1[p1]);
                p1++;
                p2++;
            }else if (nums1[p1] > nums2[p2]){
                p2++;
            }else {
                p1++;
            }
        }
        int[] t = new int[set.size()];
        p1=0;
        for (Integer i : set) {
           t[p1++] = i;
        }
        return t;
    }

    /*public int[] intersection(int[] nums1, int[] nums2) {
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
    }*/
}
