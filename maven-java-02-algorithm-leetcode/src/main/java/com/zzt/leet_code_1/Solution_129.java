package com.zzt.leet_code_1;

import com.zzt.data_structures.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * 描述：<br>129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/29 20:44
 **/
public class Solution_129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int t = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            return t;
        } else {
            return dfs(node.left, t) + dfs(node.right, t);
        }
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int i = new Solution_129().sumNumbers(root);
        System.out.println(i);
    }

}
