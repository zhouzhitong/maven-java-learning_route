package com.zzt.algorithm.sort.heap;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 21:46
 **/
public class HeapSortDemo03 {

    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 24, 6, 77, 4123, 12, 3,2,3,5,6,1,3,231};
        HeapSort heapSort = new HeapSort(arr);
        heapSort.push();
    }


    private static class HeapSort {

        private int[] heap;
        private int limit;
        private int heapSize;

        public HeapSort(int[] arr) {
            this.heap = arr;
            this.limit = arr.length;
            this.heapSize = arr.length;
        }

        public void push() {
            for (int i = heap.length - 1; i >= 0; i--) {
                heapify(i);
            }
            System.out.println(Arrays.toString(heap));
        }

        // 判断是否需要往下沉
        private void heapify(int index) {
            int l = index * 2 + 1, r;
            int largest;
            while (l < heapSize) {
                r = l + 1;
                largest = r < heapSize && heap[r] > heap[l]
                        ? r
                        : l;
                largest = heap[largest] > heap[index]
                        ? largest
                        : index;
                if (largest == index) {
                    break;
                }
                swap(largest, index);
                index = largest;
                l = index * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }

    }

}
