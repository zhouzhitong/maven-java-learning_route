package com.zzt.algorithm.leet_code.day_20_08_24;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/24 11:16
 */
public class Solution01 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int x = matrix[0].length, y = matrix.length;
        int i = 0, j = 1;
        int begin_x = 0, begin_y = 0;
        while (true) {
            while (begin_x < x) {
                result.add(matrix[begin_x][begin_y]);
                begin_x++;
            }
            x--;
            while (begin_y < y) {
                result.add(matrix[begin_x][begin_y]);
                begin_y++;
            }
            y--;
            while (i < begin_x) {
                result.add(matrix[begin_x][begin_y]);
                begin_x--;
            }
            i++;
            while (j < begin_y) {
                result.add(matrix[begin_x][begin_y]);
                begin_y--;
            }
            j++;
            break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        List<Integer> result = new Solution01().spiralOrder(matrix);
        System.out.println(result);
    }
}
