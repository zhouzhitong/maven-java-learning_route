package com.zzt.algorithm.sort.heap;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 20:48
 **/
public class HeapSortDemo02 {

    public static void main(String[] args) {
        int[] arr = {3, 9, 7, 24, 6, 77, 4123, 12, 3};
        HeapSort heapSort = new HeapSort(arr.length);
        for (int i : arr) {
            heapSort.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(heapSort.pop());
        }
    }

    private static class HeapSort {
        private int[] heap;
        private int limit;
        private int heapSize;

        public HeapSort(int maxContain) {
            this.limit = maxContain;
            this.heap = new int[this.limit];
            this.heapSize = 0;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("Heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heapSize++);
        }

        public int pop() {
            int ans = heap[0];
            swap(0, --heapSize);
            heapify();
            return ans;
        }

        private void heapify() {
            int index = 0;
            int l = 1, r;
            while (l < heapSize) {
                r = l + 1;
                int largest = r < heapSize && heap[r] > heap[l]
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

        private void heapInsert(int heapSize) {
            int parentNode;
            while (heap[heapSize] > heap[parentNode = (heapSize - 1) / 2]) {
                swap(heapSize, heapSize = parentNode);
            }
        }

        private void swap(int i, int j) {
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }
    }
}
