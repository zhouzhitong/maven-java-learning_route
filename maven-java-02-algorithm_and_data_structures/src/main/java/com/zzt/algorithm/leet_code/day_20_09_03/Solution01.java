package com.zzt.algorithm.leet_code.day_20_09_03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/3 11:13
 */
public class Solution01 {
    int N;              // 记录n
    char[][] board;     // 模拟棋盘
    List<List<String>> schemes = new LinkedList<>();    // 存放合法方案
    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (char[] line : board) {     // 初始化
            Arrays.fill(line, '.');
        }
        backtrack(0);   // 从第 1 行开始放皇后
        return schemes;
    }

    public void backtrack(int r) {
        // 结束条件
        if (r == N) {
            // 添加方案
            List<String> scheme = new LinkedList<>();
            for (char[] line : board) {
                scheme.add(String.valueOf(line));
            }
            schemes.add(scheme);
            return;
        }
        // 选择列表
        for (int j = 0; j < N; j++) {
            if (isValid(r, j)) {             // 合法才能选
                board[r][j] = 'Q';          // 选择
                backtrack(r + 1);           // 往下一层搜索
                board[r][j] = '.';          // 撤销选择，以免影响同一行其他位置的摆放
            }
        }
    }

    public boolean isValid(int x, int y) {
        // 同一行
        for (int j = 0; j < y; j++) {
            if (board[x][j] == 'Q') {
                return false;
            }
        }
        // 同一列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        // 主对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 副对角线
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> lists = new Solution01().solveNQueens(n);
        lists.forEach(System.out::println);
    }


}
