package com.zzt.algorithm.sort.barrel;

import java.util.Arrays;

/**
 * 描述：<br> 桶排序 --- 基数排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/24 16:11
 **/
public class BarrelSortDemo {

    public static void main(String[] args) {
        int[] arr = {123, 22, 1, 123, 123, 535, 4, 54, 6, 5, 6, 5, 7, 5, 75};
        BarreSort.sort(arr);
    }

    private static class BarreSort {

        public static void sort(int[] arr) {
            int maxTarget = 0;
            for (int i : arr) {
                maxTarget = Math.max(maxTarget, i);
            }
            int count = 1;
            while ((maxTarget /= 10) != 0) {
                count++;
            }
            doSort(arr, 0, arr.length - 1, count);
        }

        private static void doSort(int[] arr, int l, int r, int target) {
            int[] count, count_, help;
            int div;
            for (int i = 1; i <= target; i++) {
                count = new int[10];
                count_ = new int[10];
                help = new int[r - l + 1];
                for (int j = l; j <= r; j++) {
                    div = getDigit(arr[j], i);
                    count[div]++;
                }
                count_[0] = count[0];
                for (int i1 = 1; i1 < count_.length; i1++) {
                    count_[i1] = count[i1] + count_[i1 - 1];
                }
                for (int j = r; j >= l; j--) {
                    div = getDigit(arr[j], i);
                    help[--count_[div]] = arr[j];
                }
                for (int j = 0; j < help.length; j++) {
                    arr[l + j] = help[j];
                }
                System.out.println(Arrays.toString(arr));
            }
        }

        private static int getDigit(int target, int d) {
            for (int i = 1; i < d; i++) {
                target /= 10;
            }
            return target % 10;
        }

    }

}
