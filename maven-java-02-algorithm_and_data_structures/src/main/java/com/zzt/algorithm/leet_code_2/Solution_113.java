package com.zzt.algorithm.leet_code_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 113. 路径总和 II
 * 网址：https://leetcode-cn.com/problems/path-sum-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/26 11:54
 */
public class Solution_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
//        dfs(root.right, sum - root.val, list, result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
        list.add(root.val);
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

    }
}
