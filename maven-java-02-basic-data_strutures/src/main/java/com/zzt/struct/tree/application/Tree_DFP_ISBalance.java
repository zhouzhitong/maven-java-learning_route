package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 描述：<br>平衡二叉树的判定
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 8:44 **/
public class Tree_DFP_ISBalance {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//        root.left.left.left.left = new TreeNode(10);
        boolean balance = isBalance(root);
        System.out.println(balance);
    }

    public boolean isBalance(TreeNode root) {
        return dfs(root).isBalance;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        int high;
        boolean isBalance;
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        high = Math.max(leftInfo.high, rightInfo.high) + 1;
        isBalance = leftInfo.isBalance && rightInfo.isBalance
                && Math.abs(leftInfo.high - rightInfo.high) < 2;
        return new Info(high, isBalance);
    }


    private static class Info {
        int high;
        boolean isBalance;

        public Info(int high, boolean isBalance) {
            this.high = high;
            this.isBalance = isBalance;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "high=" + high +
                    ", isBalance=" + isBalance +
                    '}';
        }
    }

}
