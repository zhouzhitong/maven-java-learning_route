package com.zzt.struct.heap;

import java.util.*;

/**
 * 描述：<br>加强堆结构
 * </>
 *
 * @author zzt
 */
public class Heap_Struct_Firm<T> {

    private List<T> heap;
    private Map<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comp;

    public Heap_Struct_Firm(Comparator<? super T> comp) {
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
        this.comp = comp;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        this.heap.add(obj);
        indexMap.put(obj, heapSize);
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

    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.remove(obj);
        heap.remove(--heapSize);
        if (!replace.equals(obj)) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int right = left + 1;
            int larger = right < heapSize && comp.compare(heap.get(right), heap.get(left)) < 0 ? right : left;
            larger = comp.compare(heap.get(index), heap.get(larger)) > 0 ? larger : index;
            if (larger == index) {
                break;
            }
            swap(larger, index);
            index = larger;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int index) {
        int parIndex = (index - 1) / 2;
        while (comp.compare(this.heap.get(parIndex), this.heap.get(index)) > 0) {
            swap(parIndex, index);
            index = parIndex;
            parIndex = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        T t = this.heap.get(i);
        T t2 = this.heap.get(j);
        this.heap.set(i, t2);
        this.heap.set(j, t);
        this.indexMap.put(t2, i);
        this.indexMap.put(t, j);
    }

}
