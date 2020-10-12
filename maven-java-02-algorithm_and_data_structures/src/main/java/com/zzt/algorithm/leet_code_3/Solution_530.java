package com.zzt.algorithm.leet_code_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br>
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/12 11:09
 */
public class Solution_530 {

    public int getMinimumDifference(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();//建立列表存储中序遍历后的节点
        middle(root, list);//对搜索二叉树进行中序遍历---结果即为一个值依次递增的二叉树节点集
        int res = Integer.MAX_VALUE;//初始值，使res足够大
        for (int i = 0; i < list.size() - 1; i++) {//遍历列表中的节点，找出相邻节点值差绝对值的最小值即为问题的解
            res = Integer.min(res, Math.abs(list.get(i).val - list.get(i + 1).val));//每次循环更新res值
        }
        return res;
    }

    // 对搜索二叉树进行中序遍历---结果即为一个值依次递增的二叉树节点集
    public static void middle(TreeNode root, List<TreeNode> list){
        if (root == null) {
            return;
        }
        middle(root.left, list);
        list.add(root);
        middle(root.right, list);
    }


    public static void main(String[] args) {

/*        TreeNode root = new TreeNode(1476);
        root.left = new TreeNode(1054);
        root.left.right = new TreeNode(1);
        root.left.right.right = new TreeNode(215);
        root.left.right.right.right = new TreeNode(745);*/

        /*TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);*/
        /*TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);*/
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(8);
//        root.right.right = new TreeNode(3);
        int minimumDifference = new Solution_530().getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
}
