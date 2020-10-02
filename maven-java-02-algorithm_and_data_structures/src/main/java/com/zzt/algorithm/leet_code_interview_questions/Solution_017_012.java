package com.zzt.algorithm.leet_code_interview_questions;

import com.zzt.data_structures.tree.Tree;

/**
 * 描述：<br>BiNode
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/1 22:36
 **/
public class Solution_017_012 {

    private TreeNode node;

    public TreeNode convertBiNode(TreeNode root) {
        node = new TreeNode(-1);
        TreeNode l = node;
        process(root);
        return l.right;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        node.right = root;
        node.left = null;
        node = node.right;
        process(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        TreeNode treeNode = new Solution_017_012().convertBiNode(root);

        System.out.println(treeNode);
    }

}
