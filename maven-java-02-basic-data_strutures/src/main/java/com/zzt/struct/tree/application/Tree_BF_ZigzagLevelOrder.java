package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * </>
 *
 * @author zzt
 */
public class Tree_BF_ZigzagLevelOrder {

    @Test
    public void test01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TreeNode leftHelp, rightHelp;
        leftHelp = root.left;
        rightHelp = root.right;
//        leftHelp.left = new TreeNode(4);
//        leftHelp.right = new TreeNode(5);
        rightHelp.left = new TreeNode(15);
        rightHelp.right = new TreeNode(7);
//        leftHelp = leftHelp.left;
//        leftHelp.left = new TreeNode(8);

        List<List<Integer>> lists = zigzagLevelOrder(root);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode help = queue.poll();
                list.add(help.val);
                if (help.left != null) {
                    queue.offer(help.left);
                }
                if (help.right != null) {
                    queue.offer(help.right);
                }
            }
            if (flag) {
                flag = false;
                List<Integer> res = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    res.add(list.get(i));
                }
                lists.add(res);
            } else {
                flag = true;
                lists.add(list);
            }
        }
        return lists;
    }

}
