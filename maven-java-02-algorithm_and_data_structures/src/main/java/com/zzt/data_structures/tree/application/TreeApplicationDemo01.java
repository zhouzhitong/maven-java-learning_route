package com.zzt.data_structures.tree.application;

import com.zzt.data_structures.tree.Tree;

import java.util.*;

/**
 * 描述：<br>二叉树的宽度优先遍历    【用队列实现】
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 10:06
 */
public class TreeApplicationDemo01 {

    public static void traverse(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        Tree poll;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            System.out.println(poll);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        traverse(root);

    }

}
