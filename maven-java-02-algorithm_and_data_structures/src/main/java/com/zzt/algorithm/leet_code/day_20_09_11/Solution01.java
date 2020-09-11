package com.zzt.algorithm.leet_code.day_20_09_11;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>216. 组合总和III
 * 网址：https://leetcode-cn.com/problems/combination-sum-iii/comments/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/11 15:36
 */
public class Solution01 {

    private List<List<Integer>> result = new ArrayList<>();
    private Integer k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(0, n, new ArrayList<Integer>(), 0);
        return result;
    }

    /**
     * 递归
     *
     * @param count 已经添加的个数
     * @param ans   还需要的添加数值
     * @param list  存储集合
     * @param index 最近添加的值
     */
    public void dfs(int count, int ans, List<Integer> list, int index) {
        if (count == k && ans == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i < 10 && i <= ans; i++) {
            list.add(i);
            dfs(count + 1, ans - i, list, i);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(new Solution01().combinationSum3(k, n));
    }

}
