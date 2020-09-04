package com.zzt.algorithm.leet_code.day_20_09_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>257. 二叉树的所有路径
 *      网址：https://leetcode-cn.com/problems/binary-tree-paths/submissions/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 14:34
 */
public class Solution01 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root != null && root.right == null && root.left == null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            res.add(sb.toString().substring(2));
            sb.delete(len, sb.length());
            return;
        }
        if (root != null) {
            int len = sb.length();
            sb.append("->").append(root.val);
            if (root.left != null) {
                dfs(root.left, sb);
            }
            if (root.right != null) {
                dfs(root.right, sb);
            }
            sb.delete(len, sb.length());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> strings = new Solution01().binaryTreePaths(root);
        System.out.println(strings);
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
