package com.zzt.struct.dynamic.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * </>
 *
 * @author zzt
 */
public class Dynamic_LengthOfLIS {

    @Test
    public void test01() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 19};
        System.out.println(new LengthOfLIS1().lengthOfLIS(nums));
        System.out.println(new LengthOfLIS2().lengthOfLIS(nums));
        System.out.println(new LengthOfLIS3().lengthOfLIS(nums));
    }

    /** 暴力求解 */
    private static class LengthOfLIS1 {
        public int lengthOfLIS(int[] nums) {
            int process = process(nums, 0, Integer.MIN_VALUE);
            return process != 0 ? process : 1;
        }

        private int process(int[] nums, int index, int preValue) {
            if (index == nums.length) return 0;
            int p1 = process(nums, index + 1, preValue);
            int p2 = 0;
            if (nums[index] > preValue) {
                p2 = process(nums, index + 1, nums[index]) + 1;
            }
            return Math.max(p1, p2);
        }
    }

    /**
     * 动态规划  时间复杂度 O(n^2) ;
     */
    private static class LengthOfLIS2 {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int[] db = new int[nums.length];
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        db[i] = Math.max(db[i], db[j] + 1);
                    }
                }
                res = Math.max(res, db[i]);
            }
            return res + 1;
        }


    }

    /** 动态规划 时间复杂度 O(NlogN) (缺点：有点费内存) */
    private static class LengthOfLIS3 {
        Stack<Info> stack;
        PriorityQueue<Info> queue;

        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            queue = new PriorityQueue<>((a, b) -> b.maxLen - a.maxLen);
            stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                int curVal = nums[i];
                int maxLen = getMaxLen(curVal);
                queue.offer(new Info(maxLen, curVal));
            }
            return queue.poll().maxLen;
        }

        private int getMaxLen(int curVal) {
            int maxLen = 1;
            while (!queue.isEmpty()) {
                Info poll = queue.poll();
                stack.push(poll);
                if (poll.maxVal < curVal) {
                    maxLen = poll.maxLen + 1;
                    break;
                }
            }
            stack.forEach(queue::offer);
            return maxLen;
        }

        private static class Info {
            int maxLen;
            int maxVal;

            public Info(int maxLen, int maxVal) {
                this.maxLen = maxLen;
                this.maxVal = maxVal;
            }
        }
    }

}
