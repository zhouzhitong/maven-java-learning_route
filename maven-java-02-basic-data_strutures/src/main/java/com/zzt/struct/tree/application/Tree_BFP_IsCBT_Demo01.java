package com.zzt.struct.tree.application;

import com.zzt.struct.tree.logarithm.TreeLogarithm;
import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 描述：<br>1、判断是否是完全二叉树（宽度优先遍历）
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 7:02 **/
public class Tree_BFP_IsCBT_Demo01 {

    @Test
    public void test02() {
        int maxLevel = 3;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode root = TreeLogarithm.generateRandomBST(maxLevel, maxValue);
            boolean cbt = isCBT(root);
            System.out.println(cbt);
        }
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8); // true
        root.left.left.right = new TreeNode(9); // true
//        root.left.left.left.left = new TreeNode(10); // false
        boolean cbt = isCBT(root);
        System.out.println(cbt);
    }

    /**
     方法一：使用 栈结构
     @param root
     @return
     */
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFull = false;  // 左右孩子是否双全的判断（默认 true，左右孩子双全）
        TreeNode help, left, right;
        while (!queue.isEmpty()) {
            help = queue.poll();
            left = help.left;
            right = help.right;
            /*// 无左，有右
            if (    // 不算是二叉树的情况
                    left == null && right != null || isFull && left != null// 不是左右双全，但又不是叶子节点
            )*/
            if (    // 不算是二叉树的情况
                    ((isFull) && (left != null || right != null))// 不是左右双全，但又不是叶子节点
                            ||
                            (left == null && right != null) // 无左，有右
            ) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                isFull = true;
            }
        }
        return true;
    }

}
