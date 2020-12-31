package com.zzt.struct.heap.demo;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class TestDemo01 {

    @Test
    public void test01() {
        MyHeap<Integer> myHeap = new MyHeap<>(new MinComparator());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        myHeap.push(3);
        myHeap.push(4);
        myHeap.push(5);
        myHeap.push(1);
        myHeap.push(2);

        Integer pop = myHeap.pop();
        pop = myHeap.pop();
        pop = myHeap.pop();
        pop = myHeap.pop();
        pop = myHeap.pop();
    }

    private static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}
