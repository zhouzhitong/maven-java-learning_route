package com.zzt.algorithm.sort.fast;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/21 21:29
 **/
public class FastSortDemo {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        for (int i = 0; i < 20; i++) {
            int[] arr = getArr();
//        int[] arr = {0, 2, 4};
            FastSort.sort(arr);
//        int fast = FastSort.fast(arr, 0, arr.length - 1, arr[0]);
//        System.out.println(fast);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[] getArr() {
        Random random = new Random();
        int len = random.nextInt(20);
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }

    private static class FastSort {

        public static void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
//            int mid = l + (r - l >> 1);
//            int mid = (l + r) >> 1;
            int t = fast(arr, l, r, arr[l]);
            sort(arr, l, t);
            sort(arr, t + 1, r);

        }

        public static int fast(int[] arr, int l, int r, int target) {
            while (l < r) {
//                System.out.println(arr[4] + " -- " + target);
//                System.out.println(l + " -- " + r);
//                System.out.println(Arrays.toString(arr));
                if (arr[l] < target) {
                    l++;
                } else if (arr[l] > target) {
                    swap(arr, l, r--);
                } else {
                    swap(arr, l, arr[l] != arr[r] ? r : r--);

                }
            }
            return l;
        }

        private static void swap(int[] arr, int i, int j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }

    }

}
