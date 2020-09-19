package com.zzt.algorithm.sort.merger;

import java.util.Arrays;

/**
 * 描述：<br>归并排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 22:25
 **/
public class MergerSortDemo01 {

    public static void main(String[] args) {
        int[] arr1 = {1, 23, 53};
        int[] arr2 = {22, 23, 44, 55};
        int[] sort = MergerSort.sort(arr1, arr2);
        System.out.println(Arrays.toString(sort));
    }

    private static class MergerSort {

        public static int[] sort(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length + arr2.length];
            int count = 0;
            int i = 0, j = 0;
            while (count < result.length) {

                if (arr1[i] < arr2[j]) {
                    result[count++] = arr1[i++];
                } else {
                    result[count++] = arr2[j++];
                }
                if (i == arr1.length) {
                    while (j < arr2.length) {
                        result[count++] = arr2[j++];
                    }
                    break;
                }
                if (j == arr2.length) {
                    while (i < arr1.length) {
                        result[count++] = arr1[i++];
                    }
                    break;
                }
            }
            return result;
        }

    }

}
