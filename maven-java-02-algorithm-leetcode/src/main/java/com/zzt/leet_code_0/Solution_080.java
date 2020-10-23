package com.zzt.leet_code_0;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>80. 删除排序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/23 14:58
 */
public class Solution_080 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int curPos = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[curPos - 1]) {
                nums[++curPos] = nums[i];
            }
        }
        return curPos + 1;
    }

    @Test
    public void test01() {
        int[] arr = {1, 1, 1, 1, 2, 2};
        int i = new Solution_080().removeDuplicates(arr);
        for (int j = 0; j < i; j++) {
            System.out.println(arr[j]);
        }
    }

}
