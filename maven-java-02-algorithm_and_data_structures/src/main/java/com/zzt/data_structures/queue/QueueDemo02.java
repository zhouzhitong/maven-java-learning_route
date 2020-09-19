package com.zzt.data_structures.queue;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 22:02
 **/
public class QueueDemo02 {


    @Test
    public void testAdd() {
        Queue<Integer> queue = new Queue<>();
        queue.addFromHead(1);
        queue.addFromHead(2);
        queue.addFromHead(3);
        queue.addFromHead(4);
        System.out.println(queue);
    }

    private static class Queue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T t) {
            Node<T> node = new Node<>(t);
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head;
                this.head = node;
                this.head.last = node;
            }

        }

        @Override
        public String toString() {
            return "Queue{" +
                    "head=" + head +
                    '}';
        }
    }

    // 队列结构
    private static class Node<T> {
        private T t;
        public Node<T> next;
        public Node<T> last;

        public Node(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "t=" + t +
                    ", head=" + next +
                    '}';
        }
    }
}
