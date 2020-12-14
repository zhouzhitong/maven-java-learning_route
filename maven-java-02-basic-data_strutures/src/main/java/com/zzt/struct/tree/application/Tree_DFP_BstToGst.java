package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 描述：<br>1038. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 */
public class Tree_DFP_BstToGst {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
//        root.right.right.right = new TreeNode(8);

        TreeNode treeNode = bstToGst(root);

        System.out.println(treeNode);

    }

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfp(root);
        return root;
    }

    private int count = 0;

    private void dfp(TreeNode root) {
        if (root == null) {
            return;
        }
        dfp(root.right);
        count += root.val;
        root.val = count;
        dfp(root.left);
    }

}
