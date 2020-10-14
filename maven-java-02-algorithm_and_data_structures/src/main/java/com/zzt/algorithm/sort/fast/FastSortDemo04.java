package com.zzt.algorithm.sort.fast;

import com.zzt.algorithm.sort.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/14 10:27
 */
public class FastSortDemo04 {

    public static void main(String[] args) {
//        int[] arr = {19, 67, 28, 0, 16};
//        FastSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        logarithmTest();
    }

    private static void logarithmTest() {
        for (int i = 0; i < 1000; i++) {
            int[] arr = Logarithm.getArr(10);
            int[] copy = Arrays.copyOf(arr, arr.length);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            FastSort.sort(arr);
            Arrays.sort(copy);
            for (int a = 0; a < arr.length; a++) {
                if (arr[a] != copy[a]) {
                    System.out.println(Arrays.toString(arr1));
                    System.out.println(Arrays.toString(arr));
                    throw new RuntimeException("排序出错了");
                }
            }
        }
        System.out.println("Finish!!!");
    }

    private static class FastSort {
        public static void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = process(arr, l, r);
            sort(arr, l, mid - 1);
            sort(arr, mid, r);
        }

        private static int process(int[] arr, int l, int r) {
            int t = l;
            int val = arr[l++];
            while (l < r) {
                if (val < arr[l]) {
                    swap(arr, l, r--);
                } else {
                    l++;
                }
            }
            if (arr[t] > arr[l]) {
                swap(arr, t, l);
            }
            return l;
        }

        private static void swap(int[] arr, int i, int j) {
            if (arr[i] != arr[j]) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }

    }


}
