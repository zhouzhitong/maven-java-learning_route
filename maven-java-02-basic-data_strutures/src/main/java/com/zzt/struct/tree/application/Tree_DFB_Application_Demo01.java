package com.zzt.struct.tree.application;

import com.zzt.struct.tree.struct.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 描述：<br>面试题 04.03. 特定深度节点链表
 https://leetcode-cn.com/problems/list-of-depth-lcci/
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/10 6:29 **/
public class Tree_DFB_Application_Demo01 {

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
        ListNode[] listNodes = listOfDepth(root);
        for (ListNode listNode : listNodes) {
            System.out.println(listNode);
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        TreeNode help;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode listNode = new ListNode(0);
            ListNode helpList = listNode;
            for (int i = 0; i < size; i++) {
                help = queue.poll();
                if (help != null) {
                    helpList.next = new ListNode(help.val);
                    helpList = helpList.next;
                    if (help.left != null) {
                        queue.offer(help.left);
                    }
                    if (help.right != null) {
                        queue.offer(help.right);
                    }
//                    System.out.print(help + " 、 ");
                }
            }
            list.add(listNode.next);
//            System.out.println();
        }
        ListNode[] listNodes = new ListNode[list.size()];
        int i = 0;
        for (ListNode listNode : list) {
            listNodes[i++] = listNode;
        }
        return listNodes;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (next != null ? " , " + next : "");
        }
    }

}
