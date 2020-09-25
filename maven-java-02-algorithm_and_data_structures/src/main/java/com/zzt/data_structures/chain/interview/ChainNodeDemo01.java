package com.zzt.data_structures.chain.interview;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/25 9:39
 */
public class ChainNodeDemo01 {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
//        System.out.println(root.getMid(3));
//        System.out.println(root.getMid(4));
//        System.out.println(root.getMid(5));
        root.next = new Node<>(2);
        root.next.next = new Node<>(3);
        root.next.next.next = new Node<>(4);
        root.next.next.next.next = new Node<>(5);
//        root.printAll();
        Integer midpoint = root.getMidpoint();
        System.out.println(midpoint);
    }

    private static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this.val = val;
        }

        public void printAll() {
            Node<T> t = this;
            while (t != null) {
                System.out.println(t.val);
                t = t.next;
            }
        }

        private T midPoint;
        private int max;

        public T getMidpoint() {
            this.max = 0;
            doGet(this, 0);
            return midPoint;
        }

        private void doGet(Node<T> root, int pre) {
            if (root == null) {
                return;
            }
            max++;
            doGet(root.next, ++pre);
            if (getMidDown(max) == pre) {
                midPoint = root.val;
            }
        }

        private int getMidDown(int max) {
            if (max % 2 == 1) {
                return (max >> 1) + 1;
            }else {
                return (max >> 1) ;
            }
        }

        private int getMidOn(int max) {
            return (max >> 1) + 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
