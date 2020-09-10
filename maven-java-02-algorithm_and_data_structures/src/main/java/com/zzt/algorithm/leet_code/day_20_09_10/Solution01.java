package com.zzt.algorithm.leet_code.day_20_09_10;

import java.util.*;

/**
 * 描述：<br>40. 组合总和
 *     网址：https://leetcode-cn.com/problems/combination-sum-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/10 17:02
 */
public class Solution01 {
    private Set<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new HashSet<>();
        Arrays.sort(candidates);
        for (int j = candidates.length - 1; j >= 0; j--) {
            dfs(new ArrayList<>(), candidates, j, target);
        }
        return new ArrayList<>(result);
    }

    private void dfs(List<Integer> temp, int[] candidates, int k, int target) {
        if (k < 0) {
            return;
        }
        int a = candidates[k];
        if (a < target) {
            temp.add(a);
            for (int i = k - 1; i >= 0; i--) {
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
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution01().combinationSum2(candidates, target));
    }

}
