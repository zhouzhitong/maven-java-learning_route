package com.zzt.data_structures.recursion;

import java.util.Arrays;

/**
 * 描述：<br>问题：迷宫回溯问题。。。
 * 具体说明：https://blog.csdn.net/First_Bal/article/details/107522364
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 13:50
 */
public class MazeBacktracking {

    public static void main(String[] args) {
        int[][] ans = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(new MazeBacktracking().setWay(ans, 1, 1));
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    private boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {    //判断是否达到了终点
            //到达了终点
            return true;
        } else {
            //还未达到终点
            if (map[i][j] == 0) {    //判断(i,j)位置是否有墙
                //(i,j)位置没有墙
                //开始递归回溯
                map[i][j] = 2;
                //策略：右->下->左->上
                if (setWay(map, i, j + 1)) { //向右找
                    return true;
                } else if (setWay(map, i + 1, j)) {   //向下找
                    return true;
                } else if (setWay(map, i, j - 1)) {   //向左找
                    return true;
                } else if (setWay(map, i - 1, j)) {   //向上找
                    return true;
                } else {//走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //(i,j)位置有墙
                return false;
            }
        }
    }


}
