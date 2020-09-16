package com.zzt.algorithm.leet_code.day_20_09_15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述：<br> 226. 翻转二叉树（简单）
 * 网址：https://leetcode-cn.com/problems/invert-binary-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/16 17:56
 */
public class Solution01 {

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> vals = new Stack<>();
        queue.offer(root);
        vals.push(root.val);
        int size;
        TreeNode node;
        while (queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                node.val = vals.pop();
                queue.offer(node.left);
                vals.push(node.left.val);
                queue.offer(node.right);
                vals.push(node.right.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {

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