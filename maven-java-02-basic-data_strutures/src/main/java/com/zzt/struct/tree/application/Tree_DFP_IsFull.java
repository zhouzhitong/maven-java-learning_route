package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 描述：<br> 判定是否是 满二叉树
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 11:13 **/
public class Tree_DFP_IsFull {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

//        root.left.right.right = new TreeNode(3);
        boolean validBST = isFull(root);
        System.out.println(validBST);
    }


    public boolean isFull(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info info = dfs(root);
        System.out.println(info.high);
        System.out.println(info.count);
        return (1 << info.high) - 1 == info.count;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);
        int high = Math.max(leftInfo.high, rightInfo.high) + 1;
        int count = leftInfo.count + rightInfo.count + 1;
        return new Info(count, high);
    }

    private static class Info {
        int count;
        int high;

        public Info(int count, int high) {
            this.count = count;
            this.high = high;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "count=" + count +
                    ", high=" + high +
                    '}';
        }
    }

}
