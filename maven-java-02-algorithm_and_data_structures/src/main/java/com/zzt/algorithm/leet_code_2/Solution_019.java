package com.zzt.algorithm.leet_code_2;

import com.zzt.algorithm.data_structures.ListNode;

import java.util.List;

/**
 * 描述：<br>19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/19 22:51
 **/
public class Solution_019 {
    private ListNode root;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next != null) {
            dfs(head, null, n);
        } else {
            if (n == 1) {
                return null;
            }
        }
        return root!=null?root:head;
    }

    private int dfs(ListNode node, ListNode parent, int n) {
        if (node == null) {
            return 0;
        }
        int t = dfs(node.next, node, n) + 1;
        if (t == n) {
            if (parent != null) {
                parent.next = node.next;
            } else {
                 root= node.next;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Solution_019().removeNthFromEnd(head, 2);
        System.out.println("==============");
        System.out.println(listNode);
    }

}
