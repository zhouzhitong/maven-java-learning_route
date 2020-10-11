package com.zzt.algorithm.sort.insert;

import com.zzt.algorithm.sort.Logarithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 描述：<br>插入排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/25 23:51
 **/
public class InsertSortDemo {

    public static void main(String[] args) {
//        int[] arr = Logarithm.getArr(10);
//        int[] arr = {6, 5, 4, 3, 2, 1};
//        InsertSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        test();
    }

    private static void test() {
        int count = 1000;
        for (int i = 0; i < count; i++) {
            int[] arr = Logarithm.getArr(1000);
            int[] copy1 = Arrays.copyOf(arr, arr.length);
            int[] copy2 = Arrays.copyOf(arr, arr.length);
            InsertSort.sort(copy1);
            Arrays.sort(copy2);
            for (int j = 0; j < copy1.length; j++) {
                if (copy1[j]!=copy2[j]){
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(copy1));
                    throw new RuntimeException("排序出错了");
                }
            }
        }
        System.out.println("Finish~~~");
    }

    private static class InsertSort {

        public static void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int l, int r) {
            int i = l + 1;
            int temp, j, x;
            while (i <= r) {
                temp = arr[j = i];
                while ((x = j - 1) >= 0 && temp < arr[x]) {
                    arr[j--] = arr[x];
                }
                arr[j] = temp;
                i++;
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
