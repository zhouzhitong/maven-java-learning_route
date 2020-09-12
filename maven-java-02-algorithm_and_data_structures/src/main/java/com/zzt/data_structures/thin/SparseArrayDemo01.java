package com.zzt.data_structures.thin;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 *     网址：https://blog.csdn.net/First_Bal/article/details/107522364
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 16:03
 */
public class SparseArrayDemo01 {

    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][3] = 2;
        arr[9][9] = 8;
        List<Point> points = new ArrayList<>();
        Point point = new Point(10, 10, 0);
        points.add(point);
        int count = 0;
        int x = 0, y;
        for (int[] ints : arr) {
            y = 0;
            for (int anInt : ints) {
                if (anInt != 0) {
                    points.add(new Point(x, y, anInt));
                    count++;
                }
                y++;
            }
            x++;
        }
        point.value = count;
        System.out.println(points);
    }

    private static class Point {
        private int x;
        private int y;
        private int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    '}';
        }
    }


}
