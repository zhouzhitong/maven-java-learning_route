package com.zzt.algorithm.sort.fast;

import com.zzt.logarithm.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br> 快速排序算法实现 -- 递归版
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 22:36
 **/
public class ArraySort {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] arr = Logarithm.getArr(10, 100);
            int[] sourceData = Arrays.copyOf(arr, arr.length);
            int[] comparativeData = Arrays.copyOf(arr, arr.length);
            Arrays.sort(comparativeData);
            sort(arr);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != comparativeData[j]) {
                    System.out.println("排序错误 -- 源数据：\n" + Arrays.toString(sourceData));
                    System.out.println("排序 -- 自己的排序结果：\n" + Arrays.toString(arr));
                    System.out.println("排序 -- 正确排序结果：\n" + Arrays.toString(comparativeData));
                    return;
                }
            }
        }
    }


    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return ;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = doSort(arr, l, r);
        process(arr, l, i - 1);
        process(arr, i + 1, r);

    }


    private static int doSort(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            if (arr[l] < temp) {
                l++;
            } else if (arr[l] > temp) {
                swap(arr, l, r--);
            } else {
                swap(arr, l, arr[l] != arr[r] ? r : r--);
            }
        }
        return l;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
