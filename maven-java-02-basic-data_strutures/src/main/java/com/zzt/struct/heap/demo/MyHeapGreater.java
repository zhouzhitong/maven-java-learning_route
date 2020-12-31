package com.zzt.struct.heap.demo;

import java.util.*;

/**
 * 描述：<br>加强堆 ( 不存在从重复值 )
 * 额外的功能：
 * 1. 删除某个节点
 * 2. 给某个节点值，重新赋值
 * </>
 *
 * @author zzt
 */
public class MyHeapGreater<T> {

    private List<T> heap;
    private int heapSize;
    private Map<T, Integer> indexMap;
    private Comparator<? super T> comp;

    public MyHeapGreater(Comparator<? super T> comp) {
        this.comp = comp;
        this.heap = new ArrayList<>();
        this.heapSize = 0;
        this.indexMap = new HashMap<>();
    }

    public void push(T t) {
        heap.add(t);
        indexMap.put(t, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T t = peek();
        swap(0, --heapSize);
        heap.remove(heapSize);
        indexMap.remove(t);
        heapify(0);
        return t;
    }

    public void remove(int index) {
        T remove = heap.remove(index);
        heapSize--;
        indexMap.remove(remove);
    }

    public void remove(T t) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(t);
        heap.remove(--heapSize);
        indexMap.remove(t);
        if (!replace.equals(t)) {
            heap.set(index, replace);
            resign(t);
        }
    }

    public void resign(T t) {
        heapInsert(indexMap.get(t));
        heapify(indexMap.get(t));
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T t) {
        return heap.contains(t);
    }

    public T peek() {
        return heap.get(0);
    }

    private void heapify(int index) {
        int l = index * 2 + 1;
        while (l < heapSize) {
            int r = l + 1;
            int largest = r < heapSize
                    && comp.compare(heap.get(r), heap.get(l)) < 0
                    ? r : l;
            largest = comp.compare(heap.get(largest), heap.get(index)) < 0
                    ? largest : index;
            if (largest == index) {
                return;
            }
            swap(largest, index);
            index = largest;
            l = index * 2 + 1;
        }
    }

    private void heapInsert(int index) {
        int par = (index - 1) / 2;
        while (comp.compare(heap.get(index), heap.get(par)) < 0) {
            swap(par, index);
            index = par;
            par = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T t = heap.get(i);
        T t1 = heap.get(j);

        heap.set(i, t1);
        indexMap.put(t1, i);

        heap.set(j, t);
        indexMap.put(t, j);
    }

}
