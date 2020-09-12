package com.zzt.algorithm.leet_code.day_20_09_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：<br> 637. 二叉树的层平均值
 *     网址：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/12 13:37
 */
public class Solution01 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>(); // 保证 有序（便于 存取同一层元素）
        queue.offer(root);
        double curSum;
        int curSize;

        /*
            开始 bfs
         */
        while (!queue.isEmpty()) {
            curSize = queue.size();
            curSum = 0;

            for (int i = 0; i < curSize; i++) { // 每次循环都是 同一层的元素
                TreeNode node = queue.poll();   // 将 队首节点 取出
                curSum += node.val;

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(curSum / curSize);
        }

        return averages;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution01().averageOfLevels(root));

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