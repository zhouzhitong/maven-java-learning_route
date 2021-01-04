package com.zzt.offer_0;

import com.zzt.data_structures.TreeNode;

/**
 * 描述：<br>剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * </>
 *
 * @author zzt
 */
public class Solution_055 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBal;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        int deep = Math.max(leftInfo.deep, rightInfo.deep) + 1;
        boolean isBal = leftInfo.isBal && rightInfo.isBal
                && (Math.abs(rightInfo.deep - leftInfo.deep) < 2);
        return new Info(isBal, deep);
    }

    private static class Info {
        boolean isBal;
        int deep;

        public Info(boolean isBal, int deep) {
            this.isBal = isBal;
            this.deep = deep;
        }
    }

}
