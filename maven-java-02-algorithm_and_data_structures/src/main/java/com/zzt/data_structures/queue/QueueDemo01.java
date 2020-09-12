package com.zzt.data_structures.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：<br>队列：
 *  特点：1. 先进先出。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 17:50
 */
public class QueueDemo01 {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}
