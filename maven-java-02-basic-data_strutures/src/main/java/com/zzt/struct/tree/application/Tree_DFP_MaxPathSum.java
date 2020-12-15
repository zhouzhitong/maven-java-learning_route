package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 描述：<br>124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 */
public class Tree_DFP_MaxPathSum {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        int i = maxPathSum(root);
        System.out.println(i);
    }

    public int maxPathSum(TreeNode root) {
        return dfp(root).sumPath;
    }

    private Info dfp(TreeNode root) {
        /*if (root == null) {
            return null;
        }
        Info leftInfo = dfp(root.left);
        Info rightInfo = dfp(root.right);

        int sumPre = 0;
        int sumPath = root.val;
        if (leftInfo != null) {
            sumPre = leftInfo.sumPre;
            sumPath += leftInfo.sumPath;
        }
        if (rightInfo != null) {
            sumPre = Math.max(sumPre, rightInfo.sumPath);
            sumPath += rightInfo.sumPath;
        }
        if (leftInfo != null) {
            sumPath = Math.max(sumPath, leftInfo.sumPath);
        }
        if (rightInfo != null) {
            sumPath = Math.max(sumPath, rightInfo.sumPath);
        }
        sumPre += root.val;
        return new Info(sumPre, sumPath);*/
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = dfp(root.left);
        Info rightInfo = dfp(root.right);

        int sumPre = root.val + Math.max(Math.max(leftInfo.sumPre, rightInfo.sumPre), 0);
        int sumPath = root.val + (Math.max(leftInfo.sumPre, 0)) + (Math.max(rightInfo.sumPre, 0));
        if (root.left != null) {
            sumPath = Math.max(sumPath, leftInfo.sumPath);
        }
        if (root.right != null) {
            sumPath = Math.max(sumPath, rightInfo.sumPath);
        }
        return new Info(sumPre, sumPath);
    }

    private static class Info {
        int sumPre;     // 当前路径和（单边路径）
        int sumPath;    // 当前最大的路径和

        public Info(int sumPre, int sumPath) {
            this.sumPre = sumPre;
            this.sumPath = sumPath;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "sumPre=" + sumPre +
                    ", sumPath=" + sumPath +
                    '}';
        }
    }

}
