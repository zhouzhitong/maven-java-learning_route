package com.zzt.algorithm.leet_code_2;

import java.util.List;

/**
 * 描述：<br> 24. 两两交换链表中的节点
 * 网址：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * </>
 *
 * @author 周志通
 * @date 2020/10/8 15:33
 **/
public class Solution_024 {

    public ListNode swapPairs(ListNode head) {
        ListNode root = head;
        while (head != null) {
            if (head.next != null) {
                swap(head, head.next);
                head = head.next.next;
            } else {
                break;
            }
        }
        return root;
    }

    private void swap(ListNode l1, ListNode l2) {
        int val = l1.val;
        l1.val = l2.val;
        l2.val = val;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        root = new Solution_024().swapPairs(root);
        System.out.println(root);

    }

}
