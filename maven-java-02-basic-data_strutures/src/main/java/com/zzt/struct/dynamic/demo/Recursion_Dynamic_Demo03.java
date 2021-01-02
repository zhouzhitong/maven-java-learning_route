package com.zzt.struct.dynamic.demo;

/**
 描述：<br>
 题目内容：
 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 玩家A和玩家B依次拿走每张纸牌
 规定玩家A先拿，玩家B后拿
 但是每个玩家每次只能拿走最左或最右的纸牌
 玩家A和玩家B都绝顶聪明
 请返回最后获胜者的分数。
 </>
 @author 周志通
 @version 1.0.0
 @date 2021/1/2 17:54 **/
public class Recursion_Dynamic_Demo03 {

    public static void main(String[] args) {
        int[] arr = {7, 4, 16, 15, 1};
        System.out.println(Win01.getMaxSum(arr));
        System.out.println(Win02.getMaxSum(arr));
        System.out.println(Win03.getMaxSum(arr));
    }

    /**
     暴力递归版本：
     思路：从先手 A 一方考虑，从左右取最大
     从后手 B 一方考虑，从左右取最小的给 A
     */
    private static class Win01 {
        public static int getMaxSum(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            return Math.max(f(0, arr.length - 1, arr),
                    g(0, arr.length - 1, arr));
        }

        private static int f(int l, int r, int[] arr) {
            if (l == r) {
                return arr[l];
            }
            int lVal = arr[l] + g(l + 1, r, arr);
            int rVal = arr[r] + g(l, r - 1, arr);
            return Math.max(lVal, rVal);
        }

        private static int g(int l, int r, int[] arr) {
            if (l == r) {
                return 0;
            }
            int lVal = f(l + 1, r, arr);
            int rVal = f(l, r - 1, arr);
            return Math.min(lVal, rVal);
        }
    }

    /**
     优化版本：有重复过程 + 缓存
     思路：从先手 A 一方考虑，从左右取最大
     从后手 B 一方考虑，从左右取最小的给 A
     优化：期间有重复的过程，将重复的过程缓存起来
     */
    private static class Win02 {
        public static int getMaxSum(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int len = arr.length;
            int[][] fMap = new int[len][len];
            int[][] gMap = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    fMap[i][j] = -1;
                    gMap[i][j] = -1;
                }
            }
            return Math.max(f(0, arr.length - 1, arr, fMap, gMap),
                    g(0, arr.length - 1, arr, fMap, gMap));
        }

        private static int f(int l, int r, int[] arr, int[][] fMap, int[][] gMap) {
            if (fMap[l][r] != -1) {
                return fMap[l][r];
            }
            int ans;
            if (l == r) {
                ans = arr[l];

            } else {
                int lVal = arr[l] + g(l + 1, r, arr, fMap, gMap);
                int rVal = arr[r] + g(l, r - 1, arr, fMap, gMap);
                ans = Math.max(lVal, rVal);
            }
            fMap[l][r] = ans;
            return ans;
        }

        private static int g(int l, int r, int[] arr, int[][] fMap, int[][] gMap) {
            if (gMap[l][r] != -1) {
                return gMap[l][r];
            }
            int ans = 0;
            if (l != r) {
                int lVal = f(l + 1, r, arr, fMap, gMap);
                int rVal = f(l, r - 1, arr, fMap, gMap);
                ans = Math.min(lVal, rVal);
            }
            gMap[l][r] = ans;
            return ans;
        }
    }

    /**
     优化版本：动态规划
     */
    private static class Win03 {

        public static int getMaxSum(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int len = arr.length;
            int[][] fMap = new int[len][len];
            int[][] gMap = new int[len][len];
            for (int i = 0; i < len; i++) {
                fMap[i][i] = arr[i];
            }
            for (int startCol = 1; startCol < len; startCol++) {
                int l = 0;
                int r = startCol;
                while (r < len) {
                    fMap[l][r] = Math.max(arr[l] + gMap[l + 1][r], arr[r] + gMap[l][r - 1]);
                    gMap[l][r] = Math.min(fMap[l + 1][r], fMap[l][r - 1]);
                    l++;
                    r++;
                }
            }
            return Math.max(fMap[0][len - 1], gMap[0][len - 1]);
        }

    }


}
