package com.zzt.algorithm.sort.fast;

import com.zzt.logarithm.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/12 16:43
 */
public class ArraySort02 {

    public static void main(String[] args) {
//        int[] arr = {74, 36, 74, 36, 74, 96, 68, 95, 63};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
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
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int fast = doSort(arr, l, r);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(fast);
        process(arr, l, fast - 1);
        process(arr, fast + 1, r);
    }

    private static int doSort(int[] arr, int l, int r) {
        int target = arr[l];
        int i = l;
        while (l < r) {
            while (target <= arr[r] && l < r) {
                r--;
            }
            while (target >= arr[l] && l < r) {
                l++;
            }
            if (l < r) {
                swap(arr, l, r--);
            }
        }
        arr[i] = arr[l];
        arr[l] = target;
        return l;
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
