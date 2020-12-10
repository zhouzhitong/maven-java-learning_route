package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 描述：<br> 113. (目标)路径总和 II
 https://leetcode-cn.com/problems/path-sum-ii/
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/11 6:16 **/
public class Tree_DF_Application_Demo02 {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode leftHelp, rightHelp;
        leftHelp = root.left;
        rightHelp = root.right;
        leftHelp.left = new TreeNode(4);
        leftHelp.right = new TreeNode(5);
//        rightHelp.left = new TreeNode(6);
        rightHelp.right = new TreeNode(7);
        leftHelp = leftHelp.left;
        leftHelp.left = new TreeNode(8);
        leftHelp.right = new TreeNode(8);
        List<List<Integer>> lists = pathSum(root, 15);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> help) {
        if (node == null) {
            return;
        }
        if (sum == node.val) {
            if (node.left == null && node.right == null) {
                help.add(node.val);
                result.add(new ArrayList<>(help));
                help.remove(help.size() - 1);
            }
        }
        help.add(node.val);
        dfs(node.left, sum - node.val, result, help);
        dfs(node.right, sum - node.val, result, help);
        help.remove(help.size() - 1);
    }

}
