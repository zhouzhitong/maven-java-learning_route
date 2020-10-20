package com.zzt.algorithm.leet_code_2;

import com.zzt.algorithm.data_structures.ListNode;

import java.util.Stack;

/**
 * 描述：<br>143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 16:24
 */
public class Solution_143 {

    // （非递归）空间换时间
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode start = head;
        int count = 0;
        Stack<ListNode> stack = new Stack<>();
        while (start != null) {
            count++;
            stack.push(start);
            start = start.next;
        }
        count >>= 1;
        ListNode temp;
        for (int i = 0; i < count; i++) {
            temp = stack.pop();
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        head.next = null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        new Solution_143().reorderList(root);
        System.out.println(root);
    }

}
