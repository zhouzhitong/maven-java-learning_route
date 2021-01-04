package com.zzt.leet_code_0;

import com.zzt.data_structures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述：<br> 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * </>
 *
 * @author zzt
 */
public class Solution_086 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode help = head;
        while (help != null) {
            queue.offer(help);
            help = help.next;
        }
        head = queue.poll();
        help = head;
        while (!queue.isEmpty()) {
            help.next = queue.poll();
            help = help.next;
        }
        help.next = null;
        return head;
    }

}
