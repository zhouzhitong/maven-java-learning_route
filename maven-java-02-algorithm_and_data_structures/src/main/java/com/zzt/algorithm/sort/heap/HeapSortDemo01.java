package com.zzt.algorithm.sort.heap;

import com.zzt.algorithm.sort.Logarithm;

import java.util.Arrays;

/**
 * 描述：<br> 堆结构 -- 堆排序
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/24 18:01
 **/
public class HeapSortDemo01 {

    public static void main(String[] args) {
//        int[] arr = Logarithm.getArr(10);
//        int[] arr = {90, 7, 13, 64, 36, 52, 88, 80};
//        System.out.println(Arrays.toString(arr));
//        HeapSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            int[] arr = Logarithm.getArr(100, 0);
            int[] ints = Arrays.copyOf(arr, arr.length);
            HeapSort.sort(arr);
            Arrays.sort(ints);
            for (int j = 0; j < arr.length; j++) {
                if (ints[j] != arr[j]) {
                    throw new RuntimeException("排序出错了");
                }
            }
        }
        System.out.println("Finish!!! --- 【perfect】");
    }

    private static class HeapSort {

        public static void sort(int[] arr) {
            int len = arr.length;
            for (int i = len - 1; i >= 0; i--) {
                if (getLeftChildPoint(i) < len) {
                    heapify(arr, i, arr.length);
                }
            }
            pop(arr);
        }

        private static void pop(int[] arr) {
            for (int i = arr.length - 1; i >= 0; i--) {
                swap(arr, 0, i);
                heapify(arr, 0, i);
            }
        }

        private static void heapify(int[] arr, int index, int limit) {
            int len = limit;
            int largest;
            int leftChild = getLeftChildPoint(index), rightChild;
            while (leftChild < len) {
                rightChild = leftChild + 1;
                largest = rightChild < len && arr[rightChild] > arr[leftChild] ? rightChild : leftChild;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, index, index = largest);
                leftChild = getLeftChildPoint(index);
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private static int getLeftChildPoint(int i) {
            return i << 1 | 1;
        }

        private static int getRightChildPoint(int i) {

            return i << 1 + 2;
        }

        private static int getParentPoint(int i) {
            return (i - 1) >> 1;
        }

    }

}
