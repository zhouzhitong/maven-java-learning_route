package com.zzt.algorithm.leet_code_2;

import java.util.List;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/13 11:31
 */
public class Solution_023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        int x = 0;
        while (lists[x] == null) {
            x++;
        }
        ListNode node = lists[x];
        for (int i = x + 1; i < lists.length; i++) {
            sort(node, lists[i]);
        }
        return node;
    }

    private void sort(ListNode node, ListNode temp) {
        node.val = Math.min(node.val, temp.val);
        ListNode nextTemp, parentNode = node;
        node = node.next;
        while (node != null && temp != null) {
            if (node.val > temp.val) {
                nextTemp = temp.next;
                swap(parentNode, temp);
                temp = nextTemp;
                node = parentNode.next;
            } else {
                parentNode = node;
                node = node.next;
            }
        }
        while (temp != null) {
            parentNode.next = temp;
            temp = temp.next;
        }
    }

    private void swap(ListNode node, ListNode temp) {
        ListNode t = node.next;
        node.next = temp;
        temp.next = t;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        listNodes[0] = listNode;

        listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNodes[1] = listNode;

        listNode = new ListNode(2);
        listNode.next = new ListNode(6);
        listNodes[2] = listNode;

        ListNode listNode1 = new Solution_023().mergeKLists(listNodes);
        System.out.println(listNode1);
    }

}
