package com.zzt.data_structures.recursion;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/21 15:16
 **/
public class MergerSortRecursion {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 12, 3, 5, 6, 12, 355};
        MergerSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static class MergerSort {

        public static void sort(int[] arr, int left, int right) {
            if (left == right) {
                return;
            }
            int mid = (right + left) >> 1;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

        private static void merge(int[] arr, int left, int middle, int right) {
            int p1 = left, p2 = middle + 1;
            int[] temp = new int[right - left + 1];
            int count = 0;
            while (p1 <= middle && p2 <= right) {
                temp[count++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            }
            while (p1 <= middle) {
                temp[count++] = arr[p1++];
            }
            while (p2 <= right) {
                temp[count++] = arr[p2++];
            }
            for (int i = 0; i < temp.length; i++) {
                arr[left + i] = temp[i];
            }
        }
    }
}