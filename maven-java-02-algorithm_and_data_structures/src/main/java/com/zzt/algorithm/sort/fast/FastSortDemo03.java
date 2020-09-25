package com.zzt.algorithm.sort.fast;

import com.zzt.algorithm.sort.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/24 21:58
 **/
public class FastSortDemo03 {

    public static void main(String[] args) {
//        int[] arr = {9, 7, 8, 6, 3, 3, 6, 8, 9, 12, 17, 1, 2, 5};
//        int[] arr = {6, 5, 4, 3, 2, 1};
//        FastSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        test01();
    }

    private static void test01() {
        int count = 1000;
        for (int i = 0; i < count; i++) {
            int[] arr = Logarithm.getArr(10000);
            int[] ints = Arrays.copyOf(arr, arr.length);
            int[] copy = Arrays.copyOf(arr, arr.length);
            FastSort.sort(arr);
            Arrays.sort(ints);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != ints[j]) {
                    System.out.println(Arrays.toString(copy));
                    System.out.println(Arrays.toString(arr));
                    throw new RuntimeException("程序出错了");
                }
            }
        }
        System.out.println("Finish！！！perfect---");
    }

    private static class FastSort {

        public static void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
//            int m = r + (l - r >> 1);
            int fast = fast(arr, l, r, l);
            sort(arr, l, fast - 1);
            sort(arr, fast + 1, r);
        }

        private static int fast(int[] arr, int l, int r, int target) {
            int temp = arr[target];
            while (l < r) {
                if (arr[l] < temp) {
                    l++;
                } else if (arr[l] > temp) {
                    swap(arr, l, r--);
                } else {
                    if (arr[l] == arr[r]) {
                        r--;
                    } else {
                        swap(arr, l, r);
                    }
                }
            }
            return l;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
