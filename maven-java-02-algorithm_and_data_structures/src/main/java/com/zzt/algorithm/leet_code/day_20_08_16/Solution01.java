package com.zzt.algorithm.leet_code.day_20_08_16;

import java.util.Arrays;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 733. 图像渲染 2020/8/16
 * 网址：
 * <p>个人思路：
 * </p>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/16 10:01
 **/
public class Solution01 {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.15% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 83.00% 的用户
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        move(image, sr, sc, newColor, image[sr][sc]);
        image[sr][sc] = newColor;
        return image;
    }

    private void move(int[][] image, int x, int y, int newColor, int a) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[x].length || image[x][y] != a) {
            return;
        }
        image[x][y] = newColor;
        move(image, x - 1, y, newColor, a);
        move(image, x + 1, y, newColor, a);
        move(image, x, y + 1, newColor, a);
        move(image, x, y - 1, newColor, a);
        /*if (x - 1 >= 0 && image[x - 1][y] == a) {
            image[x - 1][y] = newColor;
            move(image, x - 1, y, newColor, a);
        }
        if (x + 1 < image.length && image[x + 1][y] == a) {
            image[x + 1][y] = newColor;
            move(image, x + 1, y, newColor, a);
        }

        if (y + 1 < image[x].length && image[x][y + 1] == a) {
            image[x][y + 1] = newColor;
            move(image, x, y + 1, newColor, a);
        }

        if (y - 1 >= 0 && image[x][y - 1] == a) {
            image[x][y - 1] = newColor;
            move(image, x, y - 1, newColor, a);
        }*/
    }


    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
//        int[][] image = {{0, 0, 0}, {0, 1, 1}};
//        int sr = 1, sc = 1, newColor = 1;
        new Solution01().floodFill(image, sr, sc, newColor);
        for (int[] temp : image) {
            System.out.println(Arrays.toString(temp));
        }

    }

}
