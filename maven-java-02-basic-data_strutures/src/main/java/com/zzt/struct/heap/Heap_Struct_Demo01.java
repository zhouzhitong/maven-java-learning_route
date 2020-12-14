package com.zzt.struct.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 描述：<br>堆结构的实现（大顶堆）
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/15 6:22 **/
public class Heap_Struct_Demo01 {


    @Test
    public void test01() {
        MyHeap heap = new MyHeap(10);
        heap.push(7);
        heap.push(9);
        heap.push(8);
        heap.push(20);
        heap.push(6);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());

        System.out.println(Arrays.toString(heap.arr));
    }

    private static class MyHeap {
        private int[] arr;  // 用数组存储数据
        private int limit;  // 当前数据量大小
        private int size;   // 栈结构的最大容量

        public MyHeap(int size) {
            this.arr = new int[size];
            this.size = size;
            this.limit = 0;
        }

        public boolean push(int val) {
            if (limit >= size) {
                return false;
            }
            arr[limit] = val;
            heapify(limit++);
            return true;
        }

        public int pop() {
            if (limit < 0) {
                return -1;
            }
            int res = arr[0];
            swap(0, --limit);
            parsePop(limit);
            return res;
        }

        private void heapify(int limit) {
            int help = arr[limit];
            while (limit > 0) {
                int temp = (limit - 1) / 2;
                if (arr[temp] < help) {
                    arr[limit] = arr[temp];
                } else {
                    break;
                }
                limit = temp;
            }
            arr[limit] = help;
        }

        private void parsePop(int limit) {
            int index = 0;
            int leftChild;
            int largest;
            while ((leftChild = index * 2 + 1) < limit) {
                int rightChild = leftChild + 1;
                largest = (rightChild < limit && arr[leftChild] < arr[rightChild])
                        ? rightChild : leftChild;
                largest = arr[index] < arr[largest]
                        ? largest : index;

                if (largest == index) {
                    break;
                }
                swap(index, largest);
                index = largest;
            }

        }

        private void swap(int i, int j) {
            if (arr[i] == arr[j]) {
                return;
            }
            arr[i] = arr[j] ^ arr[i];
            arr[j] = arr[j] ^ arr[i];
            arr[i] = arr[j] ^ arr[i];
        }
    }

}
