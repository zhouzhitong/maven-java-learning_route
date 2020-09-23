package com.zzt.algorithm.sort.fast;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/23 8:20
 **/
public class FastSortDemo02 {

    public static void main(String[] args) {
        int[] tep = {70, 93, 18, 62, 94, 17, 93};
        FastSort.sort(tep);
        System.out.println(Arrays.toString(tep));
//        for (int i = 0; i < 2; i++) {
//            int[] arr = getArr();
//            System.out.println(Arrays.toString(arr));
//            FastSort.sort(arr);
//            System.out.println(Arrays.toString(arr));
//
//        }
    }

    private static class FastSort {

        public static void sort(int[] arr) {
            if (arr.length <= 1) {
                return;
            }
            sort(arr, 0, arr.length - 1);
        }

        public static void sort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
            int fast = fast(arr, l, l, r);
            sort(arr, l, fast - 1);
            sort(arr, fast + 1, r);

        }

        public static int fast(int[] arr, int l, int target, int r) {
            System.out.println(l + " -- " + r);
            int temp = arr[target];
            while (l < r) {
                if (arr[l] < temp) {
                    l++;
                } else if (arr[l] > temp) {
                    swap(arr, l, r--);
                } else {
                    swap(arr, l, arr[l] != arr[r] ? r : r--);
                }
            }
            System.out.println(Arrays.toString(arr));
            return l;
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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
}
