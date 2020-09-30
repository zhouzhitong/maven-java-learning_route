package com.zzt.data_structures.tree.application;

/**
 * 描述：<br>求出二叉树的最大距离。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/30 15:30
 **/
public class TreeApplicationDemo05 {

    public static int getMaxDistance(Node node) {
        return process(node).maxDistance;
    }

    private static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance)
                , leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance, height);
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
        private int maxDistance;
        private int height;

        public Info() {
        }

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }


}
