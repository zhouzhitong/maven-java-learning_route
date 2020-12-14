package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

import static sun.java2d.cmm.ColorTransform.In;

/**
 * 描述：<br>面试题 04.05. 合法二叉搜索树
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 **/
public class Tree_DB_IsValidBST {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root).isValidBST;
        /*if (root == null) return true;
        TreeNode maxLeft = root.left, minRight = root.right;
        // 找寻左子树中的最右（数值最大）节点
        while (maxLeft != null && maxLeft.right != null)
            maxLeft = maxLeft.right;
        // 找寻右子树中的最左（数值最小）节点
        while (minRight != null && minRight.left != null)
            minRight = minRight.left;
        // 当前层是否合法
        boolean ret = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val < minRight.val);
        // 进入左子树和右子树并判断是否合法
        return ret && isValidBST(root.left) && isValidBST(root.right);*/
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
//            return null;
            return new Info(0, Integer.MIN_VALUE, true);
        }
        Info leftInfo = dfs(root.left);
        if (!leftInfo.isValidBST) {
            return leftInfo;
        }
        Info rightInfo = dfs(root.right);
        if (!rightInfo.isValidBST) {
            return rightInfo;
        }
        boolean isValidBST = false;
        int maxVal = 0;
        int minVal = 0;
        if (root.val > leftInfo.maxVal && root.val < rightInfo.minVal) {
            maxVal = root.val;
            isValidBST = true;
        }
        return new Info(maxVal, minVal, isValidBST);
    }

    private static class Info {
        int maxVal;
        int minVal;
        boolean isValidBST;

        public Info(int maxVal, int minVal, boolean isValidBST) {
            this.maxVal = maxVal;
            this.isValidBST = isValidBST;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "maxVal=" + maxVal +
                    ", isValidBST=" + isValidBST +
                    '}';
        }
    }

}
