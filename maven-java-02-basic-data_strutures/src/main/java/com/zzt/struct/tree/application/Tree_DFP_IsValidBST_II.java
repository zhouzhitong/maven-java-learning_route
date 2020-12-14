package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 描述：<br>最大 二叉搜索 子树
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/12 15:15 **/
public class Tree_DFP_IsValidBST_II {

    @Test
    public void test02() {

    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        int maxValidBST = getMaxValidBST(root);
        System.out.println(maxValidBST);
    }

    private int getMaxValidBST(TreeNode root) {
        return dfs(root).size;
    }

    private Info dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = dfs(root.left);
        Info rightInfo = dfs(root.right);

        int maxVal = root.val;
        int minVal = root.val;
        int size = 0;
        boolean isBST = true;

        if (leftInfo != null) {
            minVal = leftInfo.minVal;
            size = leftInfo.size;
            if ((!leftInfo.isBST)
                    || (leftInfo.maxVal >= root.val)) {
                isBST = false;
            }
        }

        if (rightInfo != null) {
            maxVal = rightInfo.maxVal;
            if (rightInfo.isBST
                    && (rightInfo.minVal > root.val)
                    && isBST) {
                size += rightInfo.size;
            } else {
                isBST = false;
                size = Math.max(size, rightInfo.size);
            }
            /*if ((!rightInfo.isBST)
                    || (rightInfo.minVal <= root.val)) {
                isBST = false;
                size = Math.max(size, rightInfo.size);
            } else if (isBST) {
                size += rightInfo.size;
            } else {
                size = Math.max(size, rightInfo.size);
            }*/
        }
        if (isBST) size++;
        return new Info(maxVal, minVal, size, isBST);
    }

    private static class Info {
        int maxVal;
        int minVal;
        int size;
        boolean isBST;

        public Info(int maxVal, int minVal, int size, boolean isBST) {
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.size = size;
            this.isBST = isBST;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "maxVal=" + maxVal +
                    ", minVal=" + minVal +
                    ", size=" + size +
                    ", isBST=" + isBST +
                    '}';
        }
    }

}
