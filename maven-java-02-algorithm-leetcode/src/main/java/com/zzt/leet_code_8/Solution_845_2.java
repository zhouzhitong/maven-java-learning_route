package com.zzt.leet_code_8;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>845. 数组中的最长山脉
 *     https://leetcode-cn.com/problems/longest-mountain-in-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 15:27
 */
public class Solution_845_2 {
    public int longestMountain(int[] nums) {
        Info[] infos = new Info[nums.length];
        Info temp = new Info();
        temp.left = -1;
        int pre = -1;
        int i;
        for (i = 0; i < nums.length; i++) {
            infos[i] = new Info();
            infos[i].left = nums[i] > pre ? temp.left + 1 : 0;
            pre = nums[i];
            temp = infos[i];
        }

        pre = -1;
        temp.right = -1;
        for (i -= 1; i > -1; i--) {
            infos[i].right = nums[i] > pre ? temp.right + 1 : 0;
            pre = nums[i];
            temp = infos[i];
        }
        int max = 0;
        for (Info info : infos) {
            if (info.left != 0 && info.right != 0) {
                max = Math.max(max, info.left + info.right + 1);
            }
        }
        return max > 2 ? max : 0;
    }

    class Info {
        int left;
        int right;

        @Override
        public String toString() {
            return "Info{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Test
    public void test01() {
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        int i = new Solution_845_2().longestMountain(A);
        System.out.println(i);
    }
}
