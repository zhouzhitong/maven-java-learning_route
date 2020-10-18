package com.zzt.algorithm.leet_code_2;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/17 22:18
 **/
public class Solution_052 {

    private static class Method_2 {
        private Integer count = 0;

        public int totalNQueens(int n) {
            return count;
        }

        private void dfs() {

        }

    }

    private static class Method_1 {
        private Integer count = 0;

        public int totalNQueens(int n) {
            dfs(new int[n], 0, n);
            return count;
        }

        private void dfs(int[] arr, int i, int n) {
            if (i == n) {
                count++;
                return;
            }
            int j = 0;
            while (j < n) {
                arr[i] = j;
                if (check(arr, i) != -1) {
                    dfs(arr, 1 + i, n);
                }
                j++;
            }
        }

        private int check(int[] arr, int i, int high) {
            int s = i + 1;
            int j = i;
            while (j > -1) {
                // 判断是否在同一根排
                // 判断是否在同一个对角线
                if (Math.abs(s - j) == Math.abs(high - arr[j])) {
                    return -1;
                }
                j--;
            }
            return 1;
        }

        private int check(int[] arr, int i) {
            int t = arr[i];
            int j = i - 1;
            while (j > -1) {
                // 判断是否在同一根排
                if (t == arr[j]) {
                    return -1;
                }
                // 判断是否在同一个对角线
                if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                    return -1;
                }

                j--;
            }
            return 1;
        }

    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int n = 11;
        System.out.println(new Method_1().totalNQueens(n));
        System.out.println("运行时间："+(System.currentTimeMillis()-l));
    }

}
