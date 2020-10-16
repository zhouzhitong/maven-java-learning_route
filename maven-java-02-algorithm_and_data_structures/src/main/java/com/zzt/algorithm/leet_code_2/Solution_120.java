package com.zzt.algorithm.leet_code_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 22:15
 **/
public class Solution_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int high, int wide, int min) {
        if (triangle.size() <= high) {
            return min;
        }
        List<Integer> list = triangle.get(high);
        if (list.size() <= wide) {
            return min;
        }
        min += list.get(wide);
        int left = dfs(triangle, high + 1, wide, min);
        int right = dfs(triangle, high + 1, wide + 1, min);
        return Math.min(left, right);
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);

        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        triangle.add(list);

        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);

        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);

        int i = new Solution_120().minimumTotal(triangle);
        System.out.println(i);


    }

}
