package com.zzt.algorithm.sort.merger;

import com.zzt.algorithm.sort.Logarithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述：<br> 归并排序（复习）
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/24 17:37
 **/
public class MergerSortDemo02 {

    public static void main(String[] args) {
        int[] arr = Logarithm.getArr();
        System.out.println(Arrays.toString(arr));
        MergerSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static class MergerSort {
        public static void sort(int[] arr) {
            if (arr.length <= 1) {
                return;
            }
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            if (l == r) {
                return;
            }
            int m = r + (l - r >> 1);   // 只能是左移，不能是 '除 2'
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merger(arr, l, m, r);
        }

        private static void merger(int[] arr, int l, int m, int r) {
            int[] help = new int[r - l + 1];
            int temp = m + 1, p1 = l;
            int count = 0;
            while (l <= m && temp <= r) {
                if (arr[l] < arr[temp]) {
                    help[count++] = arr[l++];
                } else {
                    help[count++] = arr[temp++];
                }
            }
            while (l <= m) {
                help[count++] = arr[l++];
            }
            while (temp <= r) {
                help[count++] = arr[temp++];
            }
            for (int i = 0; i < help.length; i++) {
                arr[p1 + i] = help[i];
            }
        }
    }

}
