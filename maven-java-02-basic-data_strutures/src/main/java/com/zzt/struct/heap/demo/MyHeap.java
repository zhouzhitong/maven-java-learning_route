package com.zzt.struct.heap.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 描述：<br> 堆结构的生成
 * </>
 *
 * @author zzt
 */
public class MyHeap<T> {
    private List<T> heap;
    private int heapSize;

    private Comparator<? super T> comparator;

    public MyHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T t) {
        heap.add(t);
        heapInsert(heapSize++);
    }

    public T peek() {
        return heap.get(0);
    }

    public T pop() {
        T peek = peek();
        if (heapSize == 0) {
            throw new RuntimeException("堆中不存在任何的数据了！！！");
        }
        swap(0, --heapSize);
        heap.remove(heapSize);
        heapify(0);
        return peek;
    }

    public boolean isEmpty() {
        return heapSize > 0;
    }

    public boolean contains(T t) {
        return heap.contains(t);
    }

    private void heapify(int index) {
        int l = index * 2 + 1;
        while (l < heapSize) {
            int r = l + 1;
            int largestIndex = r < heapSize
                    && comparator.compare(heap.get(r), heap.get(l)) < 0
                    ? r : l;
            largestIndex = comparator.compare(heap.get(largestIndex), heap.get(index)) < 0
                    ? largestIndex : index;
            if (largestIndex == index) {
                break;
            }
            swap(largestIndex, index);
            index = largestIndex;
            l = index * 2 + 1;
        }
    }

    private void heapInsert(int index) {
        int par = (index - 1) / 2;
        while (comparator.compare(heap.get(index), heap.get(par)) < 0) {
            swap(index, par);
            index = par;
            par = (index - 1) / 2;
        }
    }


    private void swap(int i, int j) {
        if (heap.get(i) != heap.get(j)) {
            T t = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, t);
        }
    }

}
