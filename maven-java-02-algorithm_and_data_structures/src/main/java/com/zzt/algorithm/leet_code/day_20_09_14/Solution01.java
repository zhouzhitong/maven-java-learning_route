package com.zzt.algorithm.leet_code.day_20_09_14;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 94. 二叉树的中序遍历
 *     网址：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/14 17:28
 */
public class Solution01 {
    private List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        // 递归方法
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                dfs(node.left);
            }
            result.add(node.val);
            if (node.right != null) {
                dfs(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution01().inorderTraversal(root));
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