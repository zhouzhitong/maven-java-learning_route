package com.zzt.algorithm.chain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 16:28
 **/
public class ChainNodeDemo01 {
    private static Node head;

    static {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
    }

    // 单链表反转
    @Test
    public void test01() {
        Node pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            System.out.println(next);
            System.out.println(pre);
        }

        System.out.println(pre);
    }

    // 删除单链表节点
    @Test
    public void test02() throws InterruptedException {
        Node node = removeNode(head, new Node(1));
        System.out.println(node);

        List<byte[]> list = new ArrayList<>();
        while (true){
//            Thread.sleep(10);
            list.add(new byte[1024]);
        }

    }

    public Node removeNode(Node root, Node node) {
        Node pre = root;
        // 1. 判断是否是头节点
        if (pre.val == node.val) {
            return root.next;
        }
        Node now = pre.next;
        // 2. 如果删除的不是头节点
        while (now != null) {
            if (now.val == node.val) {
                pre.next = now.next;
                break;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return root;
    }


    private static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("被回收了：" + val);
        }
    }

}
