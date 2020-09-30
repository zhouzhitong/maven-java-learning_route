package com.zzt.data_structures.tree.application;

/**
 * 描述：<br>二叉树：查找当前节点的后继节点（中序遍历，的后一个节点）、前继节点
 * 条件：
 * 1. 每个节点，存在 左右子节点信息，和父节点信息。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/30 10:27
 **/
public class TreeApplicationDemo02 {

    /**
     * 求前继节点
     */
    public static Node getPredecessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return getRightMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent.parent;
                parent = node.parent;
            }
            return node;
        }

    }

    private static Node getRightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * 求后继节点
     */
    public static Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

}
