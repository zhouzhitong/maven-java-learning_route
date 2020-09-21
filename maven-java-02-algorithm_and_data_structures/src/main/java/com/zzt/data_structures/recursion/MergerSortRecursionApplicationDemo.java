package com.zzt.data_structures.recursion;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/21 20:29
 **/
public class MergerSortRecursionApplicationDemo {

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 0, 2};
        int smallAnd = MergerSortAndSmallAnd.getSmallAnd(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(smallAnd);
    }

    private static class MergerSortAndSmallAnd {
        private static Integer count = 0; // 升序对计数
        private static Integer countDescending = 0;// 降序对计数

        public static int getSmallAnd(int[] arr) {
            sort(arr, 0, arr.length - 1);
            System.out.println(countDescending);
            return count;
        }

        private static void sort(int[] arr, int l, int r) {
            if (l == r) {
                return;
            }
            int m = r + (l - r >> 2);
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merger(arr, l, m, r);
        }


        private static void merger(int[] arr, int l, int m, int r) {
            int p1 = l, p2 = m + 1;
            int i = 0;
            int[] help = new int[r - l + 1];
            while (p1 <= m && p2 <= r) {
                if (arr[p1] < arr[p2]) {
                    count += arr[p1] * (r - p2 + 1);
                    help[i++] = arr[p1++];
                } else {
                    countDescending++;
                    help[i++] = arr[p2++];
                }
            }
            while (p1 < m) {
                countDescending++;
                help[i++] = arr[p1++];

            }
            if (p1 == m) {
                help[i++] = arr[p1];
            }
            while (p2 <= r) {
                help[i++] = arr[p2++];
            }
            for (int i1 = 0; i1 < help.length; i1++) {
                arr[l + i1] = help[i1];
            }
        }

    }

}
