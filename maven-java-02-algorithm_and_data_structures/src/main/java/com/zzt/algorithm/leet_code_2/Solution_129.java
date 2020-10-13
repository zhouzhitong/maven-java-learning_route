package com.zzt.algorithm.leet_code_2;

/**
 * 描述：<br> 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/13 21:32
 **/
public class Solution_129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return val * 10 + node.val;
        } else {
            int t = val * 10 + node.val;
            int left = dfs(node.left, t);
            if (left == t) {
                left = 0;
            }
            int right = dfs(node.right, t);
            return left + right;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
//        root.right = new TreeNode(0);
//        root.left.right = new TreeNode(1);

        int i = new Solution_129().sumNumbers(root);
        System.out.println(i);

    }

}
