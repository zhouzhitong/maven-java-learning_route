package com.zzt.data_structures.tree.application;

/**
 * 描述：<br>二叉树：判断是否是平衡二叉树
 * 思路：
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/30 13:12
 **/
public class TreeApplicationDemo04 {

    public static boolean isBalanced(Node head) {
        return process2(head).isBalanced;
    }

    private static Info process2(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = true;
        if (leftInfo.isBalanced
                || rightInfo.isBalanced
                || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalanced = false;
        }
        return new Info(isBalanced, height);

    }

    private static class Node {
        private Node left;
        private Node right;
        private Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }

    private static class Info {
        private boolean isBalanced;
        private int height;

        public Info() {
        }

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

}
