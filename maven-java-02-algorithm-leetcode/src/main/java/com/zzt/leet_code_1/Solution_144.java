package com.zzt.leet_code_1;

import com.zzt.data_structures.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 14:12
 */
public class Solution_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        list.add(head.val);
        dfs(head.left, list);
        dfs(head.right, list);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new Solution_144().preorderTraversal(root);
        System.out.println(list);
    }


}
