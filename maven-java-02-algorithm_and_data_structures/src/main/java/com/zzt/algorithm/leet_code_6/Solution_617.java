package com.zzt.algorithm.leet_code_6;

import com.zzt.algorithm.data_structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述：<br> 617. 合并二叉树
 * 网址：https://leetcode-cn.com/problems/merge-two-binary-trees/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/14 22:13
 **/
public class Solution_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = dfs(t1.left, t2.left);
        root.right = dfs(t1.right, t2.right);
        return root;
    }

    private TreeNode bfs(TreeNode t1, TreeNode t2) {
        //如果t1节点为空，就返回t2节点
        if (t1 == null) {
            return t2;
        }
        //如果t2节点为空，就返回t1节点
        if (t2 == null) {
            return t1;
        }
        //队列中两棵树的节点同时存在，
        Queue<TreeNode> queue = new LinkedList<>();
        //把这两棵树的节点同时入队
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            //两棵树的节点同时出队
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            //把这两个节点的值相加，然后合并到第1棵树的节点上
            node1.val += node2.val;
            if (node1.left == null) {
                //如果node1左子节点为空，我们直接让node2的
                //左子结点成为node1的左子结点，
                node1.left = node2.left;
            } else {
                //执行到这一步，说明node1的左子节点不为空，
                //如果node2的左子节点为空就不需要合并了，
                //只有node2的左子节点不为空的时候才需要合并
                if (node2.left != null) {
                    queue.add(node1.left);
                    queue.add(node2.left);
                }
            }

            //原理同上，上面判断的是左子节点，这里判断的是右子节点
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                if (node2.right != null) {
                    queue.add(node1.right);
                    queue.add(node2.right);
                }
            }
        }
        //把第2棵树合并到第1棵树上，所以返回的是第1棵树
        return t1;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(1);
        t2.right.right = new TreeNode(7);

        TreeNode treeNode = new Solution_617().mergeTrees(t1, t2);
        System.out.println(treeNode);

    }

}