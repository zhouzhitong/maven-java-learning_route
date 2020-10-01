package com.zzt.data_structures.tree.application2;

import com.zzt.data_structures.tree.Tree;

import java.util.*;

/**
 * 描述：<br>二叉树的宽度优先遍历    【用队列实现】
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/1 1:47
 **/
public class TreeApplicationDemo01 {

    public static List<Double> traverse(Tree root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Tree> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Tree temp;
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        List<Double> traverse = traverse(root);
        System.out.println(traverse);
    }

}
