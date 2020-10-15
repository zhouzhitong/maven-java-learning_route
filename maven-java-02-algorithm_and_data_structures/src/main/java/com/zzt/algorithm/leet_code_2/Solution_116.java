package com.zzt.algorithm.leet_code_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：<br> 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 22:54
 **/
public class Solution_116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                node.next = queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            node.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node connect = new Solution_116().connect(root);
        System.out.println(connect);
    }

}
