package com.zzt.leet_code_4;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>463. 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/30 16:14
 */
public class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, j, i, 0);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int x, int y, int count) {
        if (check(y, grid.length) && check(x, grid[0].length)) {
            if (grid[y][x] == 2) {
                count--;
            }
            if (grid[y][x] == 1) {
                grid[y][x] = 2;
                // 下走
                int down = dfs(grid, x, y - 1, 1);
                // 上走
                int up = dfs(grid, x, y + 1, 1);
                // 左走
                int left = dfs(grid, x - 1, y, 1);
                // 右走
                int right = dfs(grid, x + 1, y, 1);
                return down + up + right + left;
            }
        }
        return count;
    }

    private boolean check(int x, int max) {
        return -1 < x && x < max;
    }

    @Test
    public void test01() {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int i = new Solution_463().islandPerimeter(grid);
        System.out.println(i);
    }


}
