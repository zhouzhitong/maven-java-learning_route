package com.zzt.algorithm.sort.merger;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 8:00
 **/
public class MergerSortRecursionDemo {

    public static void main(String[] args) {
        int[] arr = getArr();
        System.out.println(Arrays.toString(arr));
        MergerSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] getArr() {
        Random random = new Random();
        int len = random.nextInt(10);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    private static class MergerSort {

        public static void sort(int[] arr) {
            if (arr.length==0){
                return;
            }
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            if (l == r) {
                return;
            }
            int m = r + (l - r >> 1);
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merger(arr, l, m, r);
        }

        private static void merger(int[] arr, int l, int m, int r) {
            int[] help = new int[r - l + 1];
            int p1 = l, p2 = m + 1, i = 0;
            while (p1 <= m && p2 <= r) {
                if (arr[p1] <= arr[p2]) {
                    help[i++] = arr[p1++];
                } else {
                    help[i++] = arr[p2++];
                }
            }

            while (p1 <= m) {
                help[i++] = arr[p1++];
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
