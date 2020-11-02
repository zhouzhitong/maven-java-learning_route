package com.zzt.offer_0;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/2 20:59
 **/
public class Solution_059 {

    @Test
    public void test01() {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(2);
        queue.push(4);
        queue.push(1);

//        MaxQueue maxQueue = new MaxQueue();
//        maxQueue.push_back(1);
//        maxQueue.push_back(2);
//        maxQueue.push_back(1);
//
//        int i = maxQueue.pop_front();
//        System.out.println(i);
//        int i1 = maxQueue.max_value();
//        System.out.println(i1);
//
//        System.out.println("===============");
//        System.out.println(maxQueue.pop_front());
//        System.out.println(maxQueue.max_value());
    }

    class MaxQueue {
        Queue<Integer> queue;
        LinkedList<Integer> max;

        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>(); // LinkedList是双端链表
        }

        public int max_value() {
            return max.size() == 0 ? -1 : max.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (max.size() != 0 && max.getLast() < value) {
                // 注意：这里第二个判断条件不能带等号，
                // 即max中对于当前queue中的具有相同值的元素会全部存储，
                // 而不是存储最近的那个。
                max.removeLast();
            }
            max.add(value);
        }

        public int pop_front() {
            if (max.size() != 0 && queue.peek().equals(max.getFirst())) // Integer类型的值的比较不能直接使用==
            {
                max.removeFirst();
            }
            return queue.size() == 0 ? -1 : queue.poll();
        }

    }

    class MyQueue {
        int[] arr;
        int head, tail;

        int[] help;
        int p1, p2;

        public MyQueue() {
            arr = new int[10000];
            help = new int[10000];
            head = tail = 0;
            p1 = 0;
            p2 = 0;
        }

        public void push(int value) {
            arr[tail++] = value;
            while (p1 < p2 && help[p2] < value) {
                p2--;
            }
            if (help[p1] < value) {
                help[p1] = value;
            }else {
                p2++;
                help[p2++] = value;
            }
        }

        public int pop() {
            if (head == tail) {
                return -1;
            } else {
                if (arr[head] == help[p1]) {
                    p1++;
                }
                return arr[head++];
            }
        }

    }

}
