package com.zzt.algorithm.leet_code.day_20_09_13;

/**
 * 描述：<br> 79. 单词搜索
 *     网址：https://leetcode-cn.com/problems/word-search/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/13 13:25
 **/
public class Solution01 {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (setWay(word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean setWay(String word, int count, int i, int j) {
        if (count == word.length() - 1 && board[i][j] == word.charAt(count)) {
            return true;
        }
        int a;
        char temp;
        if (board[i][j] == word.charAt(count++)) {
            temp = board[i][j];
            board[i][j] = '1';
            if ((a = i + 1) < board.length && setWay(word, count, a, j)) {
                return true;
            } else if ((a = j + 1) < board[0].length && setWay(word, count, i, a)) {
                return true;
            } else if ((a = i - 1) >= 0 && setWay(word, count, a, j)) {
                return true;
            } else if ((a = j - 1) >= 0 && setWay(word, count, i, a)) {
                return true;
            }
            board[i][j] = temp;

        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}};
//        String work = "ABCB";
        String work = "ABCCED";
        System.out.println(new Solution01().exist(board, work));
    }


}
