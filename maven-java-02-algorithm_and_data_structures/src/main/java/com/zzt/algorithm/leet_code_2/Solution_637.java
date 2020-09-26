package com.zzt.algorithm.leet_code_2;

import com.zzt.data_structures.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述：<br> 637. 二叉树的层平均值
 * 网址：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 10:36
 */
public class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode head, left, right;
        int size;
        double sum;
        while (!queue.isEmpty()) {
            size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                head = queue.poll();
                sum += head.val;
                left = head.left;
                right = head.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            list.add(sum / size);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution_637().averageOfLevels(root));
    }
}
