package com.zzt.algorithm.sort.fast;

import com.zzt.logarithm.Logarithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/16 16:12
 */
public class FastSortDemo01 {

    @Test
    public void test01() {
        for (int i = 0; i < 100000; i++) {
            int[] arr = Logarithm.getArr();
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
        process(arr, l, fast - 1);
        process(arr, fast + 1, r);
    }

    private static int doSort(int[] arr, int l, int r) {
        int i = l;
        int temp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= temp) {
                r--;
            }
            while (l < r && arr[l] <= temp) {
                l++;
            }
            swap(arr, l, r--);
        }
        arr[i] = arr[l];
        arr[l] = temp;
        return l;
    }

    private static void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
