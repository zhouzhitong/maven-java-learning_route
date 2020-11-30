package com.zzt.algorithm.sort.heap;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>堆结构
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/16 16:53
 */
public class HeapDemo01 {

    @Test
    public void test01() {
        HeapSort heapSort = new HeapSort(10);
        heapSort.push(1);
        heapSort.push(3);
        heapSort.push(5);
        heapSort.push(7);
        heapSort.push(2);
//        heapSort.print();
        int t;
        while ((t = heapSort.pop()) != -1) {
            System.out.println(t);
        }

    }


    // 小根堆
    private static class HeapSort {

        private int[] heap; // 堆的存储结构
        private int limit;  // 堆 最大容量
        private int heapSize;   // 当前堆中元素的个数

        public HeapSort(int maxContain) {
            this.limit = maxContain;
            this.heap = new int[this.limit];
            this.heapSize = 0;
        }

        // 入栈
        public void push(int value) {
            if (this.heapSize == this.limit) {
                System.out.println("当前堆已满！！！");
            }
            heap[heapSize] = value;
            heapInsert(heapSize++);
        }

        // 出栈
        public int pop() {
            int maxValue = -1;
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
            while (index > 0 && heap[index] < heap[temp = (index - 1) >> 1]) {
                swap(index, index = temp);
            }
        }

        public void print() {
            for (int i = 0; i < heapSize; i++) {
                System.out.println(heap[i]);
            }
        }

        private void swap(int i, int j) {
            if (heap[i] == heap[j]) {
                return;
            }
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }

    }

}
