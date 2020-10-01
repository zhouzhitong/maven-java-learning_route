package com.zzt.data_structures.tree.application;

import com.zzt.data_structures.tree.Tree;

/**
 * 描述：<br> 二叉树：求 节点 a、b 的公共父节点（最低的）
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/1 16:33
 **/
public class TreeApplicationDemo07 {

    public static Tree getCommonParent(Tree root, Tree a, Tree b) {
        return process(root, a, b).node;
    }

    private static Info process(Tree root, Tree a, Tree b) {
        if (root == null) {
            return new Info(null, false, false);
        }
        Info leftInfo = process(root.left, a, b);
        Info rightInfo = process(root.right, a, b);
        boolean leftExit = root.equals(a)
                || leftInfo.isLeftExist || leftInfo.isRightExist;
        boolean rightExit = root.equals(b)
                || rightInfo.isLeftExist || rightInfo.isRightExist;
        Tree node = null;
        if (leftInfo.node != null) {
            node = leftInfo.node;
        }
        if (rightInfo.node != null) {
            node = rightInfo.node;
        }
        if (node == null) {
            if (leftExit && rightExit) {
                node = root;
            }
        }
        return new Info(node, leftExit, rightExit);
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);

        root.right = new Tree(4);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);
        Tree commonParent = getCommonParent(root, new Tree(4), new Tree(2));
        System.out.println(commonParent);
    }

    private static class Info {
        private Tree node;
        private boolean isLeftExist;
        private boolean isRightExist;

        public Info(Tree node, boolean isLeftExist, boolean isRightExist) {
            this.node = node;
            this.isLeftExist = isLeftExist;
            this.isRightExist = isRightExist;
        }
    }


}
