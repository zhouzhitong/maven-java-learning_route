package com.zzt.algorithm.leet_code.day_20_08_25;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】491. 递增子序列
 * 网址：https://leetcode-cn.com/problems/increasing-subsequences/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/25 23:15
 **/
public class Solution02 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex >= nums.length) {  // 遍历结束
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[curIndex] >= preValue) {   // 将当前元素加入，并向后遍历
            temp.add(nums[curIndex]);
            dfs(curIndex + 1, nums[curIndex], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {   // 不遍历 重复元素
            dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        for (List<Integer> subsequence : new Solution02().findSubsequences(nums)) {
            System.out.println(subsequence);
        }
        ;
    }

}
