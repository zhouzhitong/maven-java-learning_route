package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 描述：<br>面试题 04.05. 合法二叉搜索树
 https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/11 6:49 **/
public class Tree_DFP_IsValidBST {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(-85);
        root.right = new TreeNode(59);
        root.right.right = new TreeNode(71);
        root.right.right.right = new TreeNode(85);
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    @Test
    public void test02() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root).isValidBST;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        int maxVal = root.val;
        int minVal = root.val;
        boolean isValidBST = true;
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        if (leftInfo != null) {
            isValidBST = leftInfo.isValidBST && leftInfo.maxVal < root.val;
            minVal = leftInfo.minVal;
        }
        if (rightInfo != null) {
            isValidBST = isValidBST && rightInfo.isValidBST && rightInfo.minVal > root.val;
            maxVal = rightInfo.maxVal;
        }
        return new Info(maxVal, minVal, isValidBST);
    }

    private Info dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Info(root.val, root.val, true);
        }

        Info leftInfo = null;
        if (root.left != null) {
            leftInfo = dfs(root.left);
        }

        Info rightInfo = null;
        if (root.right != null) {
            rightInfo = dfs(root.right);
        }
        boolean isValidBST = true;
        int maxVal = root.val;
        int minVal = root.val;
        if (leftInfo != null) {
            if (!leftInfo.isValidBST) {
                return new Info(0, 0, false);
            }
            if (leftInfo.maxVal >= root.val) {
                isValidBST = false;
            } else {
                minVal = leftInfo.minVal;
            }
        }
        if (rightInfo != null) {
            if (!rightInfo.isValidBST) {
                return new Info(0, 0, false);
            }
            if (rightInfo.minVal <= root.val) {
                isValidBST = false;
            } else {
                maxVal = rightInfo.maxVal;
            }
        }
        return new Info(maxVal, minVal, isValidBST);
    }

    private static class Info {
        int maxVal;
        int minVal;
        boolean isValidBST;

        public Info(int maxVal, int minVal, boolean isValidBST) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.isValidBST = isValidBST;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "maxVal=" + maxVal +
                    ", minVal=" + minVal +
                    ", isValidBST=" + isValidBST +
                    '}';
        }
    }

}
