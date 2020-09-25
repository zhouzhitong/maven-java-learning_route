package com.zzt.data_structures.tree;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * 描述：<br>二叉树
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/25 14:28
 */
public class TreeDemo01_Recursion {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

//        TreeUtils.preOrderTraversal(root);
//        System.out.println("\n========================");
//        TreeUtils.preOrderTraversal2(root);
//        System.out.println("\n========================");
//        TreeUtils.midOrderTraversal(root);
//        System.out.println("\n========================");
//        TreeUtils.midOrderTraversal2(root);
        System.out.println("\n========================");
        TreeUtils.afterOrderTraversal(root);
        System.out.println("\n========================");
        TreeUtils.afterOrderTraversal2(root);
        System.out.println("\n========================");

    }

    private static class TreeUtils {
        public static void preOrderTraversal(Tree root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + "  ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void preOrderTraversal2(Tree root) {
            Stack<Tree> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Tree head = stack.pop();
                System.out.print(head.val + "  ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }

        public static void midOrderTraversal(Tree root) {
            if (root == null) {
                return;
            }
            midOrderTraversal(root.left);
            System.out.print(root.val + "  ");
            midOrderTraversal(root.right);
        }

        public static void midOrderTraversal2(Tree head) {
            Stack<Tree> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + "  ");
                    head = head.right;
                }
            }
        }

        public static void afterOrderTraversal(Tree root) {
            if (root == null) {
                return;
            }
            afterOrderTraversal(root.left);
            afterOrderTraversal(root.right);
            System.out.print(root.val + "  ");
        }

        public static void afterOrderTraversal2(Tree head) {
            Stack<Tree> stack = new Stack<>();
            stack.push(head);
            Tree c, t;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null
                        && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    t = stack.pop();
                    System.out.print(t.val + "  ");
                    head = c;
                }
            }
        }
    }

}
