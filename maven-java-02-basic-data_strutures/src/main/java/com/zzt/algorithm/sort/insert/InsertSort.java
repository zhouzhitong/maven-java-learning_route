package com.zzt.algorithm.sort.insert;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>插入排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/16 15:36
 */
public class InsertSort {

    @Test
    public void test01() {
        int[] arr = {74, 36, 74, 36, 74, 96, 68, 95, 63};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            doSort(arr, 0, i);
        }
    }

    private static void doSort(int[] arr, int l, int r) {
        int temp = arr[r], x;
        while ((x = r - 1) >= 0 && arr[x] > temp) {
            arr[r--] = arr[x];
        }
        arr[r] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
