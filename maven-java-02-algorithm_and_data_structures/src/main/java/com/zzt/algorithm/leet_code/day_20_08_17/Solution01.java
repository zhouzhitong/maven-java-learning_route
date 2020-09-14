package com.zzt.algorithm.leet_code.day_20_08_17;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 10. 平衡二叉树 2020/8/17 15:19
 * <p>网址：https://leetcode-cn.com/problems/balanced-binary-tree/</>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/17 15:19
 **/
public class Solution01 {

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        treeRoot.left.left = new TreeNode(4);
        treeRoot.left.right = new TreeNode(5);
        treeRoot.left.left.left = new TreeNode(8);
        System.out.println(new Solution01().isBalanced(treeRoot));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
