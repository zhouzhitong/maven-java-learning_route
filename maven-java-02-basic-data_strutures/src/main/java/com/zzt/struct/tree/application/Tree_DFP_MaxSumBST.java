package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;


/**
 * 描述：<br>1373. 二叉搜索子树的最大键值和
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 */
public class Tree_DFP_MaxSumBST {


    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        int i = maxSumBST(root);
        System.out.println(i);
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        int i = maxSumBST(root);
        System.out.println(i);
    }

    @Test
    public void test03() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(1);

        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(-5);
        root.left.right.left.right = new TreeNode(-3);
        int i = maxSumBST(root);
        System.out.println(i);
    }

    public int maxSumBST(TreeNode root) {
        return Math.max(dfp(root).maxSumVal, 0);
    }

    private Info dfp(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = dfp(root.left);
        Info rightInfo = dfp(root.right);
        int maxVal = root.val;
        int minVal = root.val;
        boolean isBST = true;
        int sumVal = 0;
        int maxSumVal = 0;
        if (leftInfo != null) {
            sumVal = leftInfo.sumVal;
            maxSumVal = leftInfo.maxSumVal;
            isBST = leftInfo.isBST && leftInfo.maxVal < root.val;
            if (isBST) {
                minVal = leftInfo.minVal;
            }
        }
        if (rightInfo != null) {
            maxSumVal = Math.max(maxSumVal, rightInfo.maxSumVal);
            if (isBST
                    && rightInfo.isBST
                    && rightInfo.minVal > root.val) {
                sumVal += rightInfo.sumVal;
            } else {
                isBST = false;
                sumVal = Math.max(sumVal, rightInfo.sumVal);
            }
        }
        if (isBST) sumVal += root.val;
        maxSumVal = Math.max(maxSumVal, sumVal);
        return new Info(maxVal, minVal, isBST, sumVal, maxSumVal);
    }

    private static class Info {
        int maxVal;
        int minVal;
        boolean isBST;
        int sumVal; // 当前 搜索二叉树的 所有节点值
        int maxSumVal;  // 当前 搜索二叉树的 最大节点值

        public Info(int maxVal, int minVal, boolean isBST, int sumVal, int maxSumVal) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.isBST = isBST;
            this.sumVal = sumVal;
            this.maxSumVal = maxSumVal;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "maxVal=" + maxVal +
                    ", minVal=" + minVal +
                    ", isBST=" + isBST +
                    ", sumVal=" + sumVal +
                    ", maxSumVal=" + maxSumVal +
                    '}';
        }
    }

}
