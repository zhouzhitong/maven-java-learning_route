package com.zzt.algorithm.leet_code.day_20_08_11;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 130. 被围绕的区域
 * <p>网页地址：https://leetcode-cn.com/problems/surrounded-regions/
 * 个人思路：
 *      1. 先从外围入手，依次遍历最外层的数据，判断是否为 'O',并将其修改为 '1' ;
 *      2. 当为 'O' 时，用递归的方法，依次遍历 上下左右 的位置，判断是否为 'O'，并将其修改为 '1' ;
 *      3. 最后遍历，把所有逇 'O' 变成 'X' , 将所有的 '1' 变成 'O'。
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/11 21:21
 **/
public class SolutionDemo01 {

    public void solve(char[][] board) {
        int x = board.length;
        for (int i = 0; i < x; i++) { // 第 i 行
            System.out.println("i = " + i);
            for (int j = 0; j < board[i].length; ) {
                //System.out.println("j = "+j);
                if (board[i][j] == 'O') {
                    board[i][j] = '1';
                    search(board, i, j);
                }

                if (i == 0 || i == board.length-1) {
                    j++;
                } else {
                    j += board[i].length - 1;
                }

            }
        }

        for (int i=0;i<x;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]=='1'){
                    board[i][j]='O';
                }else if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }

    /**
     * 开始递归查找
     *
     * @param board 操作的数据
     * @param i     第 i 行
     * @param j     第 j 列
     */
    private void search(char[][] board, int i, int j) {
        int temp;
        System.out.println("111");
        if (i > 0 && board[temp = i - 1][j] == 'O') {   // 向上
            board[temp][j] = '1';
            search(board, temp, j);
        }
        if (j > 0 && board[i][temp = j - 1] == 'O') {   //向左
            board[i][temp] = '1';
            search(board, i, temp);
        }
        if (i < board.length - 1 && board[temp = i + 1][j] == 'O') {  // 向下
            board[temp][j] = '1';
            search(board, temp, j);
        }

        if (j < board[i].length - 1 && board[i][temp = j + 1] == 'O') {   // 向右
            board[i][temp] = '1';
            search(board, i, temp);
        }

    }


    public static void main(String[] args) {
        char[][] board = {
                  {'X', 'X', 'X', 'X'}
                , {'X', 'O', 'O', 'X'}
                , {'X', 'X', 'O', 'X'}
                , {'X', 'O', 'O', 'X'}};
        new SolutionDemo01().solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(new String(board[i]));
        }
    }


}
