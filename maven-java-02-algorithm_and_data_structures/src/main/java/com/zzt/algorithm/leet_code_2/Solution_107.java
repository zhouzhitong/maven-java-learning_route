package com.zzt.algorithm.leet_code_2;

import java.util.*;

/**
 * 描述：<br> 107. 二叉树的层次遍历 II
 * 网址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/1 23:23
 **/
public class Solution_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        Stack<List<Integer>> result = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;
        TreeNode treeHelp;
        while (!queue.isEmpty()) {
            int size = queue.size();
            temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                treeHelp = queue.poll();
                temp.add(treeHelp.val);

                if (treeHelp.left != null) {
                    queue.offer(treeHelp.left);
                }
                if (treeHelp.right != null) {
                    queue.offer(treeHelp.right);
                }
            }
            result.add(temp);
        }
        int size = result.size();
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            r.add(result.pop());
        }
        return r;
    }

    public static void main(String[] args) {

    }

}
