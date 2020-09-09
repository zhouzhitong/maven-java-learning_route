package com.zzt.algorithm.leet_code.day_20_09_09;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 39. 组合总和
 *     网址：https://leetcode-cn.com/problems/combination-sum/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/9 16:47
 */
public class Solution01 {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        for (int j = candidates.length - 1; j >= 0; j--) {
            List<Integer> temp = new ArrayList<>();
            dfs(temp, candidates, j, target);
        }
        return result;
    }

    private void dfs(List<Integer> temp, int[] candidates, int k, int target) {
        if (k < 0) {
            return;
        }
        int a = candidates[k];

        if (a < target) {
            temp.add(a);
            for (int i = k; i >= 0; i--) {
                dfs(temp, candidates, i, target - a);
            }
            temp.remove(temp.size() - 1);
        } else if (a == target) {
            temp.add(a);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(new Solution01().combinationSum(candidates, target));
    }

}
