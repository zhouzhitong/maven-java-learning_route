package com.zzt.algorithm.sort.heap;

import java.util.Arrays;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 9:51
 **/
public class HeapSortDemo {

    public static void main(String[] args) {
        int[] arr = {9, 7, 8, 6, 3, 3, 6, 8, 9, 12,17,1,2,5};
        HeapSort heapSort = new HeapSort(arr.length);
        for (int i : arr) {
            heapSort.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(heapSort.pop());
        }
        int[] heap = heapSort.heap;
        System.out.println(Arrays.toString(heap));
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
            if (this.limit == heapSize) {
                throw new RuntimeException("堆内存已满");
            }
            heap[heapSize] = value;
            heapInsert(heapSize++);
        }

        public int pop() {
            int maxValue = 0;
            if (heapSize >= 0) {
                maxValue = heap[0];
            }
            swap(0, --heapSize);
            heapify(heapSize);
            return maxValue;
        }

        private void heapify(int heapSize) {
            int index = 0;
            int leftChild = index * 2 + 1;
            int largest;
            while (leftChild < heapSize) {
                int rightChild = leftChild + 1;
                largest = rightChild < heapSize && heap[rightChild] > heap[leftChild]
                        ? rightChild
                        : leftChild;
                largest = heap[largest] > heap[index]
                        ? largest
                        : index;
                if (largest == index) {
                    break;
                }
                swap(largest, index);
                index = largest;
                leftChild = index * 2 + 1;
            }
        }

        private void heapInsert(Integer index) {
            int temp;
            while (heap[index] > heap[temp = (index - 1) / 2]) {
                swap(index, index = temp);
            }
        }

        public void print() {
            for (int i = 0; i < heapSize; i++) {
                System.out.println(heap[i]);
            }
        }

        private void swap(int i, int j) {
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }

    }

}
