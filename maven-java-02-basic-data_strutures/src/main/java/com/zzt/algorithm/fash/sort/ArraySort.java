package com.zzt.algorithm.fash.sort;

/**
 * 描述：<br> 快速排序算法实现 -- 递归版
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 22:36
 **/
public class ArraySort {

    public static int[] sort(int[] arr) {
        process(arr, 0, arr.length - 1);
        return arr;
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int i = doSort(arr, l, r);
        process(arr, l, i);
        process(arr, i, r);

    }


    private static int doSort(int[] arr, int l, int r) {
        int t = l;
        int target = arr[l++];
        while (l < r) {

        }

        return l;
    }


}
