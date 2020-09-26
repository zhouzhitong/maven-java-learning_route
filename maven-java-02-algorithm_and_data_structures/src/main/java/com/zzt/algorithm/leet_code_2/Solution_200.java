package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br> 200. 岛屿数量
 * 网址：https://leetcode-cn.com/problems/number-of-islands/solution/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 14:35
 */
public class Solution_200 {
    private Integer count = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += dfs(grid, i, j) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (0 > i || i == grid.length || 0 > j || j == grid[i].length) {
            return false;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'0', '1', '0'}};
        int i = new Solution_200().numIslands(grid);
        System.out.println(i);
        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }
    }

}
