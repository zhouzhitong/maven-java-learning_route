package com.zzt.algorithm.leet_code_2;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/9 21:31
 **/
public class Solution_039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        int[] nums = new int[len];
        dfs(res, candidates, nums, 0, target, 0, len);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] candidates, int[] nums
            , int index, int target, int sum, int len) {
        if (sum == target) {
            List<Integer> content = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    int tmp = nums[i];
                    while (tmp-- != 0) {
                        content.add(candidates[i]);
                    }
                }
            }
            res.add(content) ;
            return;
        }
        int tempSum ;
        for (int i = index; i < len; i++) {
            tempSum = sum + candidates[i] ;
            if (tempSum <= target) {
                nums[i]++;
                dfs(res, candidates, nums, i, target, tempSum, len);
                nums[i]--;
            } else {
                break;
            }
        }
    }


}
