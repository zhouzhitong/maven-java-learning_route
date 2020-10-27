package com.zzt.leet_code_8;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>845. 数组中的最长山脉
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 14:51
 */
public class Solution_845 {

    public int longestMountain(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(nums, i, i + 1));
        }
        return max > 2 ? max : 0;
    }

    private int dfs(int[] arr, int left, int right) {
        int l = 0, r = 0;
        while (left > 0) {
            if (arr[left--] > arr[left]) {
                l++;
            } else {
                break;
            }
        }
        if (l==0){
            return 0;
        }
        while (right < arr.length) {
            if (arr[right - 1] > arr[right]) {
                r++;
            } else {
                break;
            }
            right++;
        }
        if (r == 0) {
            return 0;
        }
        return l + r + 1;
    }

    @Test
    public void test01() {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        int i = new Solution_845().longestMountain(A);
        System.out.println(i);
    }

}
