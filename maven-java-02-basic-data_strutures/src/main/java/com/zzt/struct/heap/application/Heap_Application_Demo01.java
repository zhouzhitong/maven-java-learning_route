package com.zzt.struct.heap.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 **/
public class Heap_Application_Demo01 {

    @Test
    public void test01() {
        int[][] arrays = {{1, 7}, {4, 6}, {2, 3}, {4, 5}, {4, 8}, {3, 5}};
        int sumCount = getSumCount(arrays);
        System.out.println(sumCount);

        int maxSumPathCount = getMaxSumPathCount(arrays);
        System.out.println(maxSumPathCount);

    }

    public int getSumCount(int[][] arrays) {
        int count = 0;
        // 1. 排序（小到大）
        Arrays.sort(arrays, Comparator.comparingInt(o -> o[0]));
        // 小跟堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(arrays[0][1]);
        for (int i = 1; i < arrays.length; i++) {
            int begin = arrays[i][0];
            int end = arrays[i][1];
            while (!queue.isEmpty() && begin >= queue.peek()) {
                queue.poll();
            }
            count += queue.size();
            queue.offer(end);
        }
        return count;
    }

    public int getMaxSumPathCount(int[][] arrays) {
        int maxCount = 0;
        // 1. 排序（小到大）
        Arrays.sort(arrays, Comparator.comparingInt(o -> o[0]));
        // 小跟堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(arrays[0][1]);
        for (int i = 1; i < arrays.length; i++) {
            int begin = arrays[i][0];
            int end = arrays[i][1];
            while (!queue.isEmpty() && begin >= queue.peek()) {
                queue.poll();
            }
            queue.offer(end);
            maxCount = Math.max(maxCount, queue.size());
        }
        return maxCount;
    }

}
