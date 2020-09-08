package com.zzt.algorithm.leet_code.day_20_09_08;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 77. 组合
 *     网址：https://leetcode-cn.com/problems/combinations/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 11:58
 */
public class Solution01 {

    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) {
            return null;
        }
        result = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        return result;
    }

    private void dfs(int n, int k, int index, List<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Solution01().combine(n, k));
    }

}
