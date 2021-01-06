package com.zzt.struct.dynamic.demo02;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br> 0-1 背包问题
 * </>
 *
 * @author zzt
 */
public class DynamicDemo_Backpack_0Or1 {

    @Test
    public void test01() {
        int[] weights = {3, 2, 4, 7, 4};
        int[] values = {5, 6, 3, 19, 8};
        int bag = 11;
        System.out.println(Backpack_0Or1_1.getMaxValue(weights, values, bag));
        System.out.println(Backpack_0Or1_2.getMaxValue(weights, values, bag));
    }

    /** 暴力递归求解 */
    private static class Backpack_0Or1_1 {
        /**
         * @param w   第 i 件物品的重量
         * @param v   第 i 件物品的价值
         * @param bag 背包的最大容量
         * @return 最大价值
         */
        public static int getMaxValue(int[] w, int[] v, int bag) {
            return process(w, v, 0, bag);
        }

        private static int process(int[] w, int[] v, int index, int curBag) {
            if (index == w.length) {
                return 0;
            }
            int p1 = process(w, v, index + 1, curBag);
            int p2 = 0;
            if (w[index] <= curBag) {
                p2 = v[index] + process(w, v, index + 1, curBag - w[index]);
            }
            return Math.max(p1, p2);
        }

    }

    /** 动态规划 */
    private static class Backpack_0Or1_2 {
        /**
         * @param w   第 i 件物品的重量
         * @param v   第 i 件物品的价值
         * @param bag 背包的最大容量
         * @return 最大价值
         */
        public static int getMaxValue(int[] w, int[] v, int bag) {
            int len = w.length;
            /**
             * row：第 i 件商品
             * col：已经使用了的空间数量
             */
            int[][] db = new int[len][bag + 1];
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < bag + 1; j++) {
                    int p1 = db[i - 1][j];
                    int p2 = 0;
                    if (j >= w[i]) {
                        p2 = v[i] + db[i - 1][j - w[i]];
                    }
                    db[i][j] = Math.max(p1, p2);
                }
            }
            return db[len - 1][bag];
        }
    }

}
