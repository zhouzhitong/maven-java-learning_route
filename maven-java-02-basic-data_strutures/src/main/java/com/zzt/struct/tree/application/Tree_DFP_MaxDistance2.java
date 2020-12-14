package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 描述：<br>两点之间最大的距离II
 问题详细：给定一棵二叉树的头结点 head，任何两个节点之间都存在距离，
 返回二叉树，经过头结点的最大距离
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 11:35 **/
public class Tree_DFP_MaxDistance2 {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(3);
        root.left.left.left.left.left = new TreeNode(3);
        root.left.left.left.left.left.left = new TreeNode(3);

        root.left.right = new TreeNode(0);
        root.left.right.left = new TreeNode(3);
        root.left.right.left.left = new TreeNode(3);
        root.left.right.left.left.left = new TreeNode(3);
        root.left.right.left.left.left.left = new TreeNode(3);

        int maxDistance = getMaxDistance(root);
        System.out.println(maxDistance);
    }

    public int getMaxDistance(TreeNode root) {
        return dfs(root).maxDistance;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        int high = Math.max(leftInfo.high, rightInfo.high) + 1;
        int maxDistance = leftInfo.high + rightInfo.high + 1;
        return new Info(high, maxDistance);
    }

    private static class Info {
        int high;
        int maxDistance;

        public Info(int high, int maxDistance) {
            this.maxDistance = maxDistance;
            this.high = high;
        }
    }

}
