package com.zzt.algorithm.sort.fast;

import com.zzt.logarithm.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/30 21:19
 **/
public class ArraySort03 {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] arr = Logarithm.getArr(5);
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
        if (arr == null || arr.length < 1) {
            return;
        }
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int process = process(arr, l, r);
        doSort(arr, l, process - 1);
        doSort(arr, process + 1, r);
    }

    private static int process(int[] arr, int l, int r) {
        int i = l;
        int target = arr[i];
        while (true) {
            while (l < r && arr[r] >= target) r--;
            while (l < r && arr[l] <= target) l++;
            if (l < r) {
                swap(arr, l, r--);
            } else {
                arr[i] = arr[l];
                arr[l] = target;
                break;
            }
        }
        return l;
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