package com.zzt.data_structures.tree.application;

import com.zzt.data_structures.tree.Tree;

/**
 * 描述：<br> 给出最大二叉搜索子树最大路径
 * - 给定一棵二叉树的头节点 head，
 * - 返回这课二叉树中最大的二叉搜索子树的头结点。
 * </>
 * 搜索二叉树：
 * - 1.若任意结点的左子树不空，则左子树上所有结点的值均不大于它的根结点的值。
 * - 2. 若任意结点的右子树不空，则右子树上所有结点的值均不小于它的根结点的值。
 * - 3.任意结点的左、右子树也分别为二叉搜索树。 [2]
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/30 16:09
 **/
public class TreeApplicationDemo06 {

    private static Tree head;
    private static int maxCount;

    public static Info getMaxSearchBinaryTree(Tree root) {
        return process(root);
    }

    private static Info process(Tree tree) {
        if (tree == null) {
            return null;
        }
        Info leftInfo = process(tree.left);
        Info rightInfo = process(tree.right);
        // 获取当前节点信息
        int min = tree.val, max = tree.val;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        boolean isAllBST = false;

        if (
            //判断左侧整体是否是搜索二叉树
                (leftInfo == null || leftInfo.isAllBST)
                        && (rightInfo == null ? true : rightInfo.isAllBST)
                        // 左树最大值要< tree.val;
                        && (leftInfo == null || leftInfo.max < tree.val)
                        && (rightInfo == null ? true : rightInfo.min > tree.val)
        ) {
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                    + 1;
            isAllBST = true;
            if (maxCount<maxSubBSTSize){
                maxCount = maxSubBSTSize;
                head = tree;
            }
        }

        return new Info(isAllBST, maxSubBSTSize, min, max);
    }

    public static void main(String[] args) {
        Tree root = new Tree(7);
        root.left = new Tree(4);
        root.right = new Tree(12);
        root.left.left = new Tree(3);
        root.left.right = new Tree(5);
        root.left.right.right = new Tree(6);
        root.right.left = new Tree(8);
        root.right.right = new Tree(10);
        System.out.println(getMaxSearchBinaryTree(root));
        System.out.println(head);
        System.out.println(maxCount);
    }

    private static class Info {
        private boolean isAllBST;
        private int maxSubBSTSize;
        private int min;
        private int max;

        public Info(boolean isAllBST, int maxSubBSTSize, int min, int max) {
            this.isAllBST = isAllBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "isAllBST=" + isAllBST +
                    ", maxSubBSTSize=" + maxSubBSTSize +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }
    }


}
