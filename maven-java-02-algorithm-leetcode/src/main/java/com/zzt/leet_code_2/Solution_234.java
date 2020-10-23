package com.zzt.leet_code_2;

import com.zzt.data_structures.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 描述：<br>234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/23 14:12
 */
public class Solution_234 {

    private ListNode help;

    public boolean isPalindrome(ListNode head) {
        help = head;
        return check(head);
    }
    private boolean check(ListNode node) {
        if (node == null) {
            return true;
        }
        boolean flag = check(node.next) && node.val == help.val;
        help = help.next;
        return flag;
    }

    @Test
    public void test01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        boolean palindrome = new Solution_234().isPalindrome(head);
        System.out.println(palindrome);
    }

}
